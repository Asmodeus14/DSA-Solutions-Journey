import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;
import java.util.PriorityQueue;
import java.util.Comparator;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Converts a JSON array to a linked list
    public static ListNode arrayToListNode(JsonArray jsonArray) {
        if (jsonArray == null || jsonArray.size() == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (JsonValue value : jsonArray) {
            current.next = new ListNode(value.asInt());
            current = current.next;
        }
        return dummy.next;
    }

    // Converts a JSON array of arrays to an array of linked lists
    public static ListNode[] arrayToListNodeArray(JsonArray jsonArrayOfArrays) {
        if (jsonArrayOfArrays == null || jsonArrayOfArrays.size() == 0) {
            return new ListNode[0];
        }
        ListNode[] lists = new ListNode[jsonArrayOfArrays.size()];
        int index = 0;
        for (JsonValue arrayValue : jsonArrayOfArrays) {
            JsonArray innerArray = arrayValue.asArray();
            lists[index++] = arrayToListNode(innerArray);
        }
        return lists;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;
            
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }
        
        return dummy.next;
    }
}