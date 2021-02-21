package com.mali.ds.bst;

import java.util.ArrayList;
import java.util.List;

public class CheckBST {

    static boolean isBST(Node root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static void inOrder(Node root, List<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.root.data = 100;

        System.out.println(isBST(tree.root));
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.insert(3);
        tree1.insert(2);
        tree1.insert(5);
        tree1.insert(1);
        tree1.insert(4);

        System.out.println(isBST(tree1.root));
    }
}
