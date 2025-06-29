class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean hasNode = false;
        
        for (ListNode node : lists) {
            ListNode cur = node;
            while (cur != null) {
                hasNode = true;
                int val = cur.val;
                if (val < min) min = val;
                if (val > max) max = val;
                cur = cur.next;
            }
        }
        
        if (!hasNode) {
            return null;
        }
        
        ListNode[] table = new ListNode[max - min + 1];
        
        for (int i = lists.length - 1; i >= 0; i--) {
            ListNode node = lists[i];
            ListNode temp;
            while (node != null) {
                temp = node.next;
                int idx = node.val - min;
                node.next = table[idx];
                table[idx] = node;
                node = temp;
            }
        }
        
        ListNode ans = new ListNode();
        ListNode p = ans;
        for (ListNode head : table) {
            if (head != null) {
                p.next = head;
                while (head.next != null) {
                    head = head.next;
                }
                p = head;
            }
        }
        
        return ans.next;
    }
}