package com.mali.ds.bst;

/* https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/?ref=leftbar-rightbar */
public class LinkedList2BalancedBST {


    static class LNode {
        int data;
        LNode next;

        LNode(int data) {
            this.data = data;
        }
    }

    static int countNodes(LNode lNode) {
        if (lNode == null) {
            return 0;
        }
        int count = 0;
        while (lNode != null) {
            count++;
            lNode = lNode.next;
        }
        return count;
    }

    static Node L2BST() {
        LNode temp = head;
        int n = countNodes(temp);
        return sol(n);
    }

    static Node sol(int n) {
        if (n == 0) {
            return null;
        }
        Node left = sol(n / 2);
        Node root = new Node(head.data);
        root.left = left;
        head = head.next;
        root.right = sol(n - n / 2 - 1);
        return root;
    }

    static LNode head;

    public static void main(String[] args) {
        LNode lNode = new LNode(1);
        lNode.next = new LNode(2);
        lNode.next.next = new LNode(3);
        lNode.next.next.next = new LNode(4);
        lNode.next.next.next.next = new LNode(5);
        lNode.next.next.next.next.next = new LNode(6);
        lNode.next.next.next.next.next.next = new LNode(7);
        head = lNode;
        Node ans = L2BST();
        System.out.println(ans);
    }

}


