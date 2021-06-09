package com.mali.ds.trees.bst;

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
    return recursion(tree.root, getTriangle(nums.length + 1)) - 1;
  }

  static int recursion(Node root, long[][] combs) {
    if (root == null) {
      return 1;
    }
    int left = count(root.left);
    int right = count(root.right);

    return (int)
        ((combs[left + right][left] % MOD * recursion(root.left, combs) % MOD)
            % MOD
            * recursion(root.right, combs)
            % MOD);
  }

  static int count(Node root) {
    if (root == null) {
      return 0;
    }
    return 1 + count(root.right) + count(root.left);
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
