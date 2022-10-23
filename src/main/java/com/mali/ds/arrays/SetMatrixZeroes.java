package com.mali.ds.arrays;

/* https://leetcode.com/problems/set-matrix-zeroes/ */
public class SetMatrixZeroes {

  //approach 1 : use extra space and mark all as visited and make their corresponding as zeroes
  // 2 : use rows and cols space only and add mark that row as zero
  // 3 in same array only mark starting row/col as zero. do the first and last row atlast.
  public static int[][] setZeroes(int[][] matrix) {

    int rl = matrix.length;
    int cl = matrix[0].length;
    for (int i = 0; i < rl; i++) {
      for (int j = 0; j < cl; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = -1;
          matrix[0][j] = -1;
        }
      }
    }

    for (int i = 1; i < rl; i++) {
      if (matrix[i][0] == -1) {
        for (int j = 0; j < cl; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < cl; i++) {
      if (matrix[0][i] == -1) {
        for (int j = 0; j < rl; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    if (matrix[0][0] == -1) {
      for (int j = 0; j < cl; j++) {
        matrix[0][j] = 0;
      }
      for (int j = 0; j < rl; j++) {
        matrix[j][0] = 0;
      }
    }

    return matrix;
  }

  public static void main(String[] args) {

    int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

    System.out.println(setZeroes(matrix));
  }
}
