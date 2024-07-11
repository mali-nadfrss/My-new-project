package com.mali.ds.dp.greedy;

/*https://leetcode.com/problems/minimum-number-of-operations-to-satisfy-conditions/description/
 * Medium*/
public class MinimumNumberofOperationstoSatisfyConditions {

  public static int minimumOperations(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    int[][] top = new int[n][10];
    for (int i = 0; i < n; i++) {

      for (int j = 0; j < m; j++) {
        top[i][grid[j][i]]++;
      }
    }

    for (int i = 0; i < 10; i++) {
      top[0][i] = m - top[0][i];
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 10; j++) {
        int val = m - top[i][j];
        top[i][j] = 100000000;
        for (int k = 0; k < 10; k++) {
          if (j != k) {
            top[i][j] = Math.min(top[i][j], val + top[i - 1][k]);
          }
        }
      }
    }
    int ans = 100000000;
    for (int i = 0; i < 10; i++) {
      ans = Math.min(ans, top[n - 1][i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] arr = {{1, 0, 2}, {1, 0, 2}};
    System.out.println(minimumOperations(arr));
  }
}
