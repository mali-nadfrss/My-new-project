package com.mali.ds.linkedList;

/* easy 2
 * https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data
 * */
public class PairWiseSwap {

    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public static Node pairwiseSwap(Node head) {
        // code here
        if (head == null) {
            return null;
        }
        Node prev = new Node();
        Node ans = prev;
        while (head != null && head.next != null) {
            Node current = head;
            Node next = head.next;
            prev.next = next;
            current.next = next.next;
            next.next = current;
            prev = current;
            head = current.next;
        }
        prev.next = head;
        return ans.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node ans = head;
        int[] A = {2, 2, 4, 5, 6, 7, 8};
        for (int i = 0; i < A.length; i++) {
            Node n = new Node(A[i]);
            head.next = n;
            head = head.next;
        }

        ans = pairwiseSwap(ans);
        System.out.print(ans);
    }
}
