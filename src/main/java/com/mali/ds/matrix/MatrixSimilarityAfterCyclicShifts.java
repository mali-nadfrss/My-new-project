package com.mali.ds.matrix;

/* https://leetcode.com/contest/weekly-contest-373/problems/matrix-similarity-after-cyclic-shifts/
 * easy
 * */
public class MatrixSimilarityAfterCyclicShifts {

  public static boolean areSimilar(int[][] mat, int k) {

    int n = mat[0].length;
    k %=n;
    for (int[] ints : mat) {
      for (int j = 0; j < n; j++) {
        if (j % 2 == 0) {
          if (ints[j] != ints[(n + j - k) % n]) {
            return false;
          }
        } else {
          if (ints[j] != ints[(j + k) % n]) {
            return false;
          }
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int[][] mat = {{2, 2}};
    int k = 3;
    System.out.println(areSimilar(mat, k));
  }
}
