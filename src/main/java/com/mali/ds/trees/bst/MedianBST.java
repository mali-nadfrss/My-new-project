package com.mali.ds.trees.bst;

public class MedianBST {
    static int ans = 0;
    static int middle = 0;
    static int count = 0;

    static int median(Node root) {
        count = 0;
        ans = 0;
        middle = 0;
        countNodes(root);
        middle = count / 2;
        findMiddle(root, true);
        if (count % 2 == 0) {
            middle = (count + 1) / 2;
            findMiddle(root, true);
            return ans / 2;
        }
        return ans;
    }

    static void findMiddle(Node root, boolean flag) {
        if (root == null) {
            return;
        }
        findMiddle(root.left, flag);
        if (middle == 0 && flag) {
            ans = ans + root.data;
            flag = false;
            return;
        } else {
            middle--;
        }
        findMiddle(root.right, flag);
    }

    static void countNodes(Node root) {
        if (root == null) {
            return;
        }
        countNodes(root.left);
        count++;
        countNodes(root.right);
    }

    public static void main(String[] args) throws Exception {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(7);
        tree.insert(60);
        tree.insert(80);
        System.out.println(median(tree.root));
    }
}
