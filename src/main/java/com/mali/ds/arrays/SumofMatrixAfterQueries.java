package com.mali.ds.arrays;

/* https://leetcode.com/contest/weekly-contest-348/problems/sum-of-matrix-after-queries/ */
public class SumofMatrixAfterQueries {

  public static long matrixSumQueries(int n, int[][] queries) {

    long ans = 0;

    int q = queries.length;
    int[] visc = new int[n];
    int[] visr = new int[n];

    int cc = 0;
    int rc = 0;

    for (int i = q - 1; i >= 0; i--) {

      if (queries[i][0] == 0 && visr[queries[i][1]] == 0) {
        if (queries[i][2] == 0) visr[queries[i][1]] = -1;
        else {
          ans += (long) queries[i][2] * (n - cc);
          visr[queries[i][1]] = queries[i][2];
        }
        rc++;
      }

      if (queries[i][0] == 1 && visc[queries[i][1]] == 0) {
        if (queries[i][2] == 0) visc[queries[i][1]] = -1;
        else {
          ans += (long) queries[i][2] * (n - rc);
          visc[queries[i][1]] = queries[i][2];
        }
        cc++;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] queries = {{0, 0, 6}, {0, 1, 5}, {0, 2, 8}, {1, 0, 5}, {1, 2, 12}, {1, 1, 0}};

    matrixSumQueries(n, queries);
  }
}
