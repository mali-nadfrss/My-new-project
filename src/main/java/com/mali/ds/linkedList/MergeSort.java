package com.mali.ds.linkedList;

/*
 * medium 4
 * https://practice.geeksforgeeks.org/problems/merge-sort-on-doubly-linked-list
 * */
public class MergeSort {

    static Node sortDoubly(Node head) {
        // add your code here
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node middleNext = middle.next;
        middle.next = null;
        Node left = sortDoubly(head);
        Node right = sortDoubly(middleNext);
        return merge(left, right);
    }

    static Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }
        Node middle = head;
        while (head.next != null && head.next.next != null) {
            middle = middle.next;
            head = head.next.next;
        }
        return middle;
    }

    static Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        Node result = new Node();
        Node prev = null;
        Node current;
        Node ans = result;
        if (left.data > right.data) {
            result.data = right.data;
            right = right.next;
        } else {
            result.data = left.data;
            left = left.next;
        }
        while (left != null || right != null) {
            if (left == null) {
                result.next = new Node(right.data);
                right = right.next;
            } else if (right == null) {
                result.next = new Node(left.data);
                left = left.next;
            } else if (left.data > right.data) {
                result.next = new Node(right.data);
                right = right.next;
            } else {
                result.next = new Node(left.data);
                left = left.next;
            }
            current = result;
            result.prev = prev;
            result = result.next;
            prev = current;

        }
        result.prev = prev;

        return ans;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        Node ans1 = head;
        int[] A = {3, 2, 1, 4};
        for (int i = 0; i < A.length; i++) {
            Node n = new Node(A[i]);
            head.next = n;
            head = head.next;
        }
        Node ans = sortDoubly(ans1);
        System.out.print(ans);
    }
}
