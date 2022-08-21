package com.mali.ds.arrays;

/* https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/ */
public class KthSmallestElementinaSortedMatrix {

  public static int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length; //3
    int low = matrix[0][0]; //1
    int high = matrix[n - 1][n - 1]; //15

    int ans = -1;
    while (low < high) {
      int mid = low + (high - low) / 2; //13
      int count = count(matrix, mid); //8
      if (count < k) {
        low = mid + 1; //13
      } else {
        ans = mid;//13
        high = mid; //13
      }
    }
    return ans;
  }

  static int count(int[][] matrix, int mid) {
    int ans = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] > mid) break;
        ans++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    int k = 8;
    System.out.println(kthSmallest(matrix, k));
  }
}
