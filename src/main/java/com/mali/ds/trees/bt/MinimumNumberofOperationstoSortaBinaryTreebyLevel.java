package com.mali.ds.trees.bt;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-319/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/ */
public class MinimumNumberofOperationstoSortaBinaryTreebyLevel {

  public class TreeNode {
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

  public int minimumOperations(TreeNode root) {
    int ans = 0;
    List<int[]> list = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();

    q.add(root);
    while (!q.isEmpty()) {
      int len = q.size();
      int[] arr = new int[len];
      for (int i = 0; i < len; i++) {
        TreeNode node = q.poll();
        arr[i] = node.val;
        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      }
      list.add(arr);
    }

    for (int[] arr : list) {
      ans += minSwaps(arr);
    }

    return ans;
  }

  public static int minSwaps(int[] arr1) {
    int n = arr1.length;
    Pair[] arr = new Pair[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Pair(arr1[i], i);
    }
    Arrays.sort(arr);
    int ans = 0;
    boolean[] vis = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (vis[i] == true || arr[i].idx == i) {
        continue;
      }
      int clen = 0;
      int j = i;
      while (vis[j] == false) {
        vis[j] = true;
        clen++;
        j = arr[j].idx;
      }
      ans += (clen - 1);
    }
    return ans;
  }

  private static class Pair implements Comparable<Pair> {
    int val;
    int idx;

    Pair(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }

    @Override
    public int compareTo(Pair o) {
      return this.val - o.val;
    }
  }
}
