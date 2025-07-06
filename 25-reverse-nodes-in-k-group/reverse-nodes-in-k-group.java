class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode tail = curr;
            int count = 0;
            while (count < k && curr != null) {
                curr = curr.next;
                count++;
            }
            if (count < k) {
                break;
            }
            ListNode reversedHead = reverse(tail, k);
            prev.next = reversedHead;
            tail.next = curr;
            prev = tail;
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}