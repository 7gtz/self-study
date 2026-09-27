/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> hm = new HashMap<>();

        ListNode current = head;

        int i = 0;

        while (current != null) {
            hm.put(i, current);
            i++;
            current = current.next;
        }

        int length = hm.size();

        ListNode element = hm.get(length - n);

        if (length == n) return element.next;

        hm.get(length - n - 1).next = element.next;
        return head;
    }
}
