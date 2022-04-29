package com.mali.ds.trees.bt;

import com.mali.ds.trees.bst.Node;

/** https://leetcode.com/problems/diameter-of-binary-tree/ easy */
public class DiameterOfBT {
  /* Complete the function to get diameter of a binary tree */
  static int diameterOfBinaryTree(Node root) {
    recursion(root);
    return ans;
  }

  static int ans = 0;

  static int recursion(Node root) {
    if (root == null) {
      return 0;
    }
    int right = recursion(root.right);
    int left = recursion(root.left);
    ans = Math.max(ans, right + left);
    return 1 + Math.max(right, left);
  }

  public static void main(String[] args) {
    Node n = new Node(1);
    n.right = new Node(3);
    n.left = new Node(2);
    n.left.left = new Node(4);
    n.left.right = new Node(5);

    System.out.println(recursion(n));
  }
}
