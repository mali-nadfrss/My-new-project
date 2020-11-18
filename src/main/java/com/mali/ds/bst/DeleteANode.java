package com.mali.ds.bst;

/* https://leetcode.com/problems/delete-node-in-a-bst/ */
public class DeleteANode {

    /* steps 1) search for the node
     *        2) find min element on right side
     *        3) replace with the element found above and delete it
     * */
    static Node deleteNode(Node n, int data) {
        if (n == null) {
            return null;
        } else if (n.data > data) {
            n.left = deleteNode(n.left, data);
        } else if (n.data < data) {
            n.right = deleteNode(n.right, data);
        } else {
            if (n.left == null) {
                return n.right;
            } else if (n.right == null) {
                return n.left;
            } else {
                n.data = min(n.right).data;
                n.right = deleteNode(n.right, data);
            }

        }
        return n;

    }

    static Node max(Node n) {
        if (n.right == null)
            return n;
        return max(n.right);
    }

    static Node min(Node n) {
        if (n.left == null)
            return n;
        return min(n.left);
    }

    public static void main(String[] args) {
        Node n = new Node(5);
        n.right = new Node(6);
        n.right.right = new Node(7);
        n.left = new Node(4);
        n.left.left = new Node(3);
        n.left.left = new Node(1);
        deleteNode(n, 5);
    }

}
