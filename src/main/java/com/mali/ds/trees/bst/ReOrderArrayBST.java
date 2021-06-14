package com.mali.ds.trees.bst;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
Hard
 */
public class ReOrderArrayBST {
  private static final long MOD = 1000000007;

  public static int numOfWays(int[] nums) {
    BinarySearchTree tree = new BinarySearchTree();
    for (int i = 0; i < nums.length; i++) {
      tree.insert(nums[i]);
    }
    return recursion(tree.root, getTriangle(nums.length + 1), new HashMap<>()) - 1;
  }

  static int recursion(Node root, long[][] combs, Map<Node, Integer> map) {
    if (root == null) {
      return 1;
    }
    int left = count(root.left, map);
    int right = count(root.right, map);

    return (int)
        ((combs[left + right][left] % MOD * recursion(root.left, combs, map) % MOD)
            % MOD
            * recursion(root.right, combs, map)
            % MOD);
  }

  static int count(Node root, Map<Node, Integer> map) {
    if (root == null) {
      return 0;
    }
    if (map.containsKey(root)) {
      return map.get(root);
    }
    int c = 1 + count(root.right, map) + count(root.left, map);
    map.put(root, c);
    return c;
  }

  private static long[][] getTriangle(int n) {
    // Yang Hui (Pascle) triangle
    // 4C2 = triangle[4][2] = 6
    long[][] triangle = new long[n][n];
    for (int i = 0; i < n; i++) {
      triangle[i][0] = triangle[i][i] = 1;
    }
    for (int i = 2; i < n; i++) {
      for (int j = 1; j < i; j++) {
        triangle[i][j] = (triangle[i - 1][j] + triangle[i - 1][j - 1]) % MOD;
      }
    }
    return triangle;
  }

  public static void main(String[] args) {
    int[] nums = {3, 1, 2, 5, 4, 6};
    System.out.println(numOfWays(nums));
  }
}
