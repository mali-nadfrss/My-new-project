package com.mali.ds.bst;

/* https://practice.geeksforgeeks.org/problems/largest-bst/1 */
public class LargestBST {

    static class NewBST {
        int size;
        boolean isBst;
        int min;
        int max;
        int data;
    }

    static NewBST construct(Node root) {
        if (root == null) {
            NewBST newBST = new NewBST();
            newBST.size = 0;
            newBST.min = Integer.MAX_VALUE;
            newBST.max = Integer.MIN_VALUE;
            newBST.isBst = true;
            return newBST;
        } else {
            NewBST left = construct(root.left);
            NewBST right = construct(root.right);
            NewBST bst = new NewBST();
            bst.data = root.data;
            if (bst.data > left.max && bst.data < right.min && left.isBst && right.isBst) {
                bst.isBst = true;
                bst.min = Math.min(bst.data, left.min);
                bst.max = Math.max(bst.data, right.max);
                bst.size = 1 + left.size + right.size;
            } else {
                bst.size = Math.max(left.size, right.size);
                bst.isBst = false;
            }
            return bst;
        }

    }


    static int largestBst(Node root) {
        NewBST bst = construct(root);
        return bst.size;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(7);
        tree.insert(60);
        tree.insert(80);
        tree.root.data = 1;

        System.out.println(largestBst(tree.root));
    }

}
