package com.mali.ds.arrays;

/* https://leetcode.com/contest/weekly-contest-328/problems/increment-submatrices-by-one/ */
public class IncrementSubmatricesbyOne {

  public static int[][] rangeAddQueries(int n, int[][] queries) {

    int[][] ans = new int[n][n];
    for (int i = 0; i < queries.length; i++) {
      sum(ans, queries[i]);
    }

    return ans;
  }

  static void sum(int[][] ans, int[] queries) {
    int x1 = queries[0];
    int y1 = queries[1];

    int x2 = queries[2];
    int y2 = queries[3];

    for (int i = x1; i <= x2; i++) {

      for (int j = y1; j <= y2; j++) {
        ans[i][j] += 1;
      }
    }
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] queries = {{1,1,2,2},{0,0,1,1}};
    System.out.println(rangeAddQueries(n , queries));

  }
}
