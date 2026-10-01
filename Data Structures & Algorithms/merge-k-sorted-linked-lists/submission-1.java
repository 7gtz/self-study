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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) minHeap.offer(list);
        }

        ListNode result = new ListNode(0);
        ListNode dummy = result;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            dummy.next = node;
            dummy = dummy.next;
            node = node.next;

            if (node != null) {
                minHeap.offer(node);
            }
        }

        return result.next;
    }
}
