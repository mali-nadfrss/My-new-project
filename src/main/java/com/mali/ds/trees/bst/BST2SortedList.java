package com.mali.ds.trees.bst;

public class BST2SortedList {

    static Node flatten(Node root, Node prev){
        if (root == null){
            return null;
        }
        root.left = flatten(root.left, prev);
        return root;
    }

    public static void main(String[] args) throws Exception {

    }
}
