package com.mali.ds.trees.bst;

/* https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/951220/Java-Recursive-Solution */
public class FlattenBST {

    public static void flatten(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.left != null) {
           flatten(root.left);
           Node temp = root.right;
           root.right = root.left;
           root.left = null;
           Node cur = root.right;
           while (cur.right != null){
               cur = cur.right;
           }
           cur.right = temp;
        }
        flatten(root.right);

    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        flatten(tree.root);
        System.out.println(tree.root);
    }
}
