package com.prakash.dsa;

/**
 * Singly linked list node plus classic linked list problems.
 */
public final class LinkedListProblems {

    private LinkedListProblems() {
    }

    public static final class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /** Builds a list from values, returning the head (null for no values). */
    public static Node of(int... values) {
        Node dummy = new Node(0), tail = dummy;
        for (int v : values) {
            tail.next = new Node(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    /** Converts a list to an array (handy for testing). */
    public static int[] toArray(Node head) {
        int n = 0;
        for (Node c = head; c != null; c = c.next) {
            n++;
        }
        int[] out = new int[n];
        int i = 0;
        for (Node c = head; c != null; c = c.next) {
            out[i++] = c.val;
        }
        return out;
    }

    /** Reverses a list iteratively. O(n) time, O(1) space. */
    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /** Returns the middle node (second middle for even length) using slow/fast pointers. */
    public static Node middle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /** Floyd's cycle detection. O(n) time, O(1) space. */
    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /** Merges two sorted lists into one sorted list. O(n + m). */
    public static Node mergeSorted(Node a, Node b) {
        Node dummy = new Node(0), tail = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }
}
