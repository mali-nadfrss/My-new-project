package com.mali.ds.linkedList;

/*
 * easy 2
 * https://practice.geeksforgeeks.org/problems/circular-linked-list-delete-at-position
 * */
public class DeleteAtPosition {

    public static Node deleteAtPosition(Node head, int pos) {
        // your code here
        if (head.next == head) {
            return null;
        }
        Node ans = head;
        Node t = head.next;
        int size = 1;
        while (head != t && t != null) {
            t = t.next;
            size++;
        }
        if (pos > size) {
            pos = pos % size;
        }
        int d = 1;
        while (d < pos) {
            head = head.next;
            d++;
        }
        Node temp = head.next;
        head.data = temp.data;
        head.next = temp.next;
        return ans;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node ans1 = head;
        int[] A = {2, 3, 4, 5};
        for (int i = 0; i < A.length; i++) {
            Node n = new Node(A[i]);
            head.next = n;
            head = head.next;
        }
        head.next = ans1;
        Node ans = deleteAtPosition(ans1, 5);
        System.out.print(ans);
    }
}
