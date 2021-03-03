package com.mali.ds.trees.bst;


// Java program to demonstrate
// delete operation in binary
// search tree
class BinarySearchTree {

    Node root;

    void insert(int data) {
        root = insertNode(root, data);
    }

    Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else if (data > node.data) {
            node.right = insertNode(node.right, data);
        } else {
            node.left = insertNode(node.left, data);
        }
        return node;
    }

    Node deleteNode(Node root, int data) {
        if (root == null) {
            return null;
        } else if (data > root.data) {
            return deleteNode(root.right, data);
        } else if (data < root.data) {
            return deleteNode(root.left, data);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                root.data = min(root.right);
                root.right = deleteNode(root.right, data);
            }
        }
        return root;
    }

    int min(Node root) {
        if (root.left == null) {
            return root.data;
        }
        return min(root.left);
    }

    int max(Node root) {
        if (root.right == null) {
            return root.data;
        }
        return max(root.right);
    }

    void delete(int data) {
        deleteNode(root, data);
    }

    void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    // Driver Code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.delete(30);
        tree.inOrder(tree.root);
    }
}