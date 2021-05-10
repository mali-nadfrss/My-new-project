package com.mali.ds.dp;

public class LongestCommonSubSequence {

  static int lcs(String[] X, String[] Y, int x, int y) {
    if (x == 0 || y == 0) {
      return 0;
    }
    if (X[x - 1] == Y[y - 1]) {
      return 1 + lcs(X, Y, x - 1, y - 1);
    }
    return Math.max(lcs(X, Y, x - 1, y), lcs(X, Y, x, y - 1));
  }
}
