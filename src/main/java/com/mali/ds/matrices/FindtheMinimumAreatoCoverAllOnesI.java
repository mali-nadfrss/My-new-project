package com.mali.ds.matrices;

/*https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/ */
public class FindtheMinimumAreatoCoverAllOnesI {
  public static int minimumArea(int[][] grid) {

    int i1 = 0, i2 = 0, j1 = 0, j2 = 0;
    int m = grid.length;
    int n = grid[0].length;
    int k = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          if (k == 0) {
            k = 1;
            i1 = i2 = i;
            j1 = j2 = j;
          } else {
            if (j1 >= j) {
              j1 = j;
            } else {
              j2 = j;
            }
            if (i1 >= i) {
              i1 = i;
            } else {
              i2 = i;
            }
          }
        }
      }
    }

    System.out.println(i1 + " " + j1 + " " + i2 + " " + j2);
    return (i2 - i1 + 1) * (j2 - j1 + 1);
  }

  public static void main(String[] args) {

    int[][] arr = {{0,0,0},{0,0,0},{1,0,1},{1,0,0}};
    minimumArea(arr);
  }
}
