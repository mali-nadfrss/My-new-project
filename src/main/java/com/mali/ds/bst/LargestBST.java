package com.mali.ds.bst;

/* https://practice.geeksforgeeks.org/problems/largest-bst/1 */
public class LargestBST {

    static class isBst {
        isBst left;
        isBst right;
        int size;
        boolean bst;
        int min;
        int max;
        int data;
    }

    static isBst construct(Node root) {
        isBst bst = new isBst();
        if (root == null) {
            bst.size = 0;
            bst.min = Integer.MAX_VALUE;
            bst.max = Integer.MIN_VALUE;
            bst.bst= false;
            return bst;
        }  else {
            bst.left = construct(root.left);
            bst.right = construct(root.right);
            if (bst.data > bst.left.data && bst.left.bst && bst.right.bst && bst.data < bst.right.data) {
                bst.bst = true;
                bst.max = Math.max(bst.right.max, bst.max);
                bst.min = Math.min(bst.left.min, bst.min);
                bst.size = 1 + bst.left.size + bst.right.size;
            } else {
                bst.size = Math.max(bst.right.size, bst.left.size);
                bst.min = bst.max = bst.data;

            }
        }
        return bst;
    }


    static int largestBst(Node root) {
        isBst bst = construct(root);
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
