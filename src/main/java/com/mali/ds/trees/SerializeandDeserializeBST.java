package com.mali.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/serialize-and-deserialize-bst/
 * medium */
public class SerializeandDeserializeBST {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Encodes a tree to a single string.
  public static String serialize(TreeNode root) {
    if (root == null) return "";
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    StringBuilder ans = new StringBuilder();
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      ans.append(node.val).append("s");
      if (node.left != null) q.add(node.left);
      if (node.right != null) q.add(node.right);
    }
    return ans.toString();
  }

  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    if (data.equals("")) return null;
    String[] s = data.split("s");
    TreeNode root = new TreeNode(Integer.parseInt(s[0]));
    for (int i = 1; i < s.length; i++) {
      int k = Integer.parseInt(s[i]);
      TreeNode cur = root;
      TreeNode prev = root;
      while (cur != null) {
        prev = cur;
        if (cur.val > k) {
          cur = cur.left;
        } else {
          cur = cur.right;
        }
      }
      if (prev.val > k) prev.left = new TreeNode(k);
      else prev.right = new TreeNode(k);
    }
    return root;
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    String ans = serialize(root);
    TreeNode ansRoot = deserialize(ans);
    System.out.println(ansRoot);
  }
}
