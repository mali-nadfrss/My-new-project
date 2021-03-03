package com.mali.ds.trees.bt;

import com.mali.ds.trees.bst.Node;

public class MirrorImage {
  static Node mirrorImage(Node head) {
    logic(head);
    return head;
  }

  static void logic(Node head) {
    if (head == null) {
      return;
    }
    Node left = head.left;
    Node right = head.right;
    head.left = right;
    head.right = left;
    logic(left);
    logic(right);
  }

  // Driver Program to test above functions
  public static void main(String[] args) {

    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.left = new Node(4);
    tree.left.right = new Node(5);
    tree.right.right = new Node(6);
    System.out.println("Following are nodes in top view of Binary Tree");
    tree = mirrorImage(tree);
    System.out.print(tree);
  }
}
