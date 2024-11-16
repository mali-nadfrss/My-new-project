package com.mali.ds.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/cousins-in-binary-tree-ii/description/ */
public class CousinsInBinaryTreeII {

  /*
   * Definition for a binary tree node.
   */
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static TreeNode replaceValueInTree(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) return null;
    root.val = 0;
    if (root.left != null) {
      root.left.val = 0;
      queue.add(root.left);
    }
    if (root.right != null) {
      root.right.val = 0;
      queue.add(root.right);
    }
    Queue<TreeNode> queue2 = new LinkedList<>();

    boolean flag = true;
    while (flag) {
      int sum = 0;
      while (!queue.isEmpty()) {

        TreeNode cur = queue.poll();

        if (cur.left != null) {
          sum += cur.left.val;
        }

        if (cur.right != null) {
          sum += cur.right.val;
        }

        queue2.add(cur);
      }
      if (queue2.isEmpty()) {
        flag = false;
      } else {
        while (!queue2.isEmpty()) {
          TreeNode cur = queue2.poll();
          int curSum = sum;
          if (cur.left != null) {
            curSum = sum - cur.left.val;
            queue.add(cur.left);
          }

          if (cur.right != null) {
            curSum = curSum - cur.right.val;
            cur.right.val = curSum;
            queue.add(cur.right);
          }
          if (cur.left != null) {
            cur.left.val = curSum;
          }
        }
      }
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(9);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(10);
    root.right.right = new TreeNode(7);
    TreeNode ans = replaceValueInTree(root);
  }
}
