package com.mali.ds.bt;

import com.mali.ds.bst.Node;

public class PrintBoundaries {

    public static void printLeafs(Node n){
        if (n == null){
            return;
        }
        printLeafs(n.left);
        if (n.right == null && n.left == null){
            System.out.println(n.data);
            return;
        }
        printLeafs(n.right);

    }

    public static  void printLeftNodes(Node n){
        if (n == null){
            return;
        }
        if (n.right != null || n.left != null){
        System.out.println(n.data);}
        printLeftNodes(n.left);
    }

    public static void printReverseRightNodes(Node n){
        if (n == null){
            return;
        }
        printReverseRightNodes(n.right);
        if (n.right != null || n.left != null){
        System.out.println(n.data);}
    }

    public static void main(String args[]) throws Exception {
        Node n = new Node(20);
        n.left = new Node(8);
        n.right = new Node(22);
        n.right.right = new Node(25);
        n.left.left = new Node(4);
        n.left.right = new Node(12);
        n.left.right.left = new Node(10);
        n.left.right.right = new Node(14);
        printReverseRightNodes(n);
        printLeftNodes(n.left);
        printLeafs(n);
    }
}
