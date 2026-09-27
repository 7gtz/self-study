class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> hm = new HashMap<>();

        Node current = head;

        // Pass 1: create a copy of every node
        while (current != null) {
            hm.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        // Pass 2: connect next and random
        while (current != null) {
            Node copy = hm.get(current);

            copy.next = hm.get(current.next);
            copy.random = hm.get(current.random);

            current = current.next;
        }

        return hm.get(head);
    }
}