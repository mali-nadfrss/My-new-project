package com.mali.ds.matrices;

/*https://leetcode.com/contest/weekly-contest-387/problems/minimum-operations-to-write-the-letter-y-on-a-grid/ */
public class MinimumOperationstoWritetheLetterYonaGrid {

  public static int minimumOperationsToWriteY(int[][] grid) {

    int one = 0;
    int two = 0;
    int zero = 0;
    int n = grid.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          zero++;
        } else if (grid[i][j] == 1) {
          one++;
        } else {
          two++;
        }
      }
    }

    int yone = 0;
    int ytwo = 0;
    int yzero = 0;

    for (int i = n / 2; i < n; i++) {
      if (grid[i][n / 2] == 0) {
        yzero++;
        zero--;
      } else if (grid[i][n / 2] == 1) {
        yone++;
        one--;
      } else {
        ytwo++;
        two--;
      }
    }

    for (int i = 0; i < n / 2; i++) {
      if (grid[i][i] == 0) {
        yzero++;
        zero--;
      } else if (grid[i][i] == 1) {
        yone++;
        one--;
      } else {
        ytwo++;
        two--;
      }
    }

    for (int i = n - 1; i > n / 2; i--) {
      if (grid[n-1-i][i] == 0) {
        yzero++;
        zero--;
      } else if (grid[n-1-i][i] == 1) {
        yone++;
        one--;
      } else {
        ytwo++;
        two--;
      }
    }

    int ans = Integer.MAX_VALUE;

    // y = 0, r= 1
    ans = Math.min(ytwo + yone + zero + two, ans);
    // y = 0, r= 2
    ans = Math.min(ytwo + yone + one + two, ans);
    // y = 1, r= 0
    ans = Math.min(ytwo + yzero + one + two, ans);
    System.out.println(ytwo + yzero + one + two);
    // y = 1, r= 2
    ans = Math.min(ytwo + yzero + zero + one, ans);
    // y = 2, r= 0
    ans = Math.min(yzero + yone + one + two, ans);
    // y = 2, r= 1
    ans = Math.min(yzero + yone + zero + two, ans);
    return ans;
  }

  public static void main(String[] args){
      int[][] grid = {{1,2,2},{1,1,0},{0,1,0}};
      minimumOperationsToWriteY(grid);
  }

}
