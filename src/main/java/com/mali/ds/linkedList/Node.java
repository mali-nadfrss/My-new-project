package com.mali.ds.linkedList;

public class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String ans = "";
        Node head = this;
        while (head != null) {
            if (head == null) {
                break;
            }
            ans = ans + "->" + head.data;
            head = head.next;
        }
        return ans;
    }
}
