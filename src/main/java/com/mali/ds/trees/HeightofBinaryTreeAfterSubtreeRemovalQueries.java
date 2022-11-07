package com.mali.ds.trees;

public class HeightofBinaryTreeAfterSubtreeRemovalQueries {

  public static class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static int max = 0;

  public static int[] treeQueries(TreeNode root, int[] queries) {
    int[] pre = new int[1000001];
    int[] post = new int[1000001];
    preOrder(root, pre, 0);
    max = 0;
    postOrder(root, post, 0);

    int[] ans = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      ans[i] = Math.max(pre[queries[i]], post[queries[i]]);
    }
    return ans;
  }

  static void preOrder(TreeNode root, int[] pre, int h) {
    if (root == null) {
      return;
    }
    pre[root.val] = max;
    max = Math.max(max, h);
    preOrder(root.left, pre, h + 1);
    preOrder(root.right, pre, h + 1);
  }

  static void postOrder(TreeNode root, int[] post, int h) {
    if (root == null) {
      return;
    }
    post[root.val] = max;
    max = Math.max(max, h);
    postOrder(root.right, post, h + 1);
    postOrder(root.left, post, h + 1);
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(4);

    root.left.left = new TreeNode(2);

    root.right.right = new TreeNode(5);
    root.right.left = new TreeNode(6);

    root.right.right.right = new TreeNode(7);
    System.out.println(treeQueries(root, new int[] {4}));
  }
}
