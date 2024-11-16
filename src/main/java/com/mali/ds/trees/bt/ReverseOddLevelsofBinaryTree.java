package com.mali.ds.trees.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* https://leetcode.com/contest/weekly-contest-311/problems/reverse-odd-levels-of-binary-tree/ */
public class ReverseOddLevelsofBinaryTree {

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

  public TreeNode reverseOddLevels(TreeNode root) {

    if (root == null) return root;
    int level = 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      int[] temp = new int[q.size()];
      int len = q.size();
      Stack<TreeNode> stack = new Stack<>();
      for (int i = 0; i < len; i++) {
        TreeNode cur = q.poll();
        if (cur != null) {
          temp[i] = cur.val;
          q.add(cur.left);
          q.add(cur.right);
          stack.add(cur);
        }
      }
      if (level % 2 == 1) {
        for (int i = 0; i < len && !stack.isEmpty(); i++) {
          TreeNode cur = stack.pop();
          cur.val = temp[i];
        }
      }

      level++;
    }
    return root;
  }

  public static void main(String[] args) {

    ReverseOddLevelsofBinaryTree obj = new ReverseOddLevelsofBinaryTree();
    TreeNode node = new TreeNode(2);
    node.left = new TreeNode(3);
    node.right = new TreeNode(5);
    node.left.left = new TreeNode(8);
    node.right.left = new TreeNode(21);
    node.left.right = new TreeNode(13);
    node.right.right = new TreeNode(34);
    obj.reverseOddLevels(node);
  }
}
