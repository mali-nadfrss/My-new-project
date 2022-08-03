package com.mali.ds.maths;

/* hackerearth*/
public class MatrixGCD {
  static int solve(int N, int M, int[][] mat) {
    // Write your code here
    int result = 0;
    int r = N;
    int c = M;
    int[][] count = new int[r][c];
    for (int i = 0; i < r; i++) {
      int g = mat[i][0];
      for (int j = 1; j < c; j++) {
        g = gcd(mat[i][j], g);
      }
      if (g > 1) {
        incrementCountRow(i, count);
      }
    }

    for (int i = 0; i < c; i++) {
      int g = mat[0][i];
      for (int j = 1; j < r; j++) {
        g = gcd(mat[j][i], g);
      }
      if (g > 1) {
        incrementCountCoulmn(i, count);
      }
    }

    if (r > c) {
      for (int i = 0; i < r; i++) {
        if (count[i][0] > 0) {
          result = decrementCountRow(i, count, result);
        }
      }

      for (int i = 0; i < c; i++) {
        if (count[0][i] > 0) {
          result = decrementCountCoulmn(i, count, result);
        }
      }
    } else {
      for (int i = 0; i < c; i++) {
        if (count[0][i] > 0) {
          result = decrementCountCoulmn(i, count, result);
        }
      }
      for (int i = 0; i < r; i++) {
        if (count[i][0] > 0) {
          result = decrementCountRow(i, count, result);
        }
      }
    }

    return result;
  }

  static int decrementCountCoulmn(int i, int[][] count, int result) {
    int k = -1;
    for (int j = 0; j < count.length; j++) {
      if (count[j][i] > 1) {
        k = j;
      }
      count[j][i] -= 1;
    }
    if (k > -1) {
      for (int j = 0; j < count[0].length; j++) {
        count[k][j] -= 1;
      }
    }
    return result + 1;
  }

  static int decrementCountRow(int i, int[][] count, int result) {
    int k = -1;
    for (int j = 0; j < count[0].length; j++) {
      if (count[i][j] > 1) {
        k = j;
      }
      count[i][j] -= 1;
    }
    if (k > -1) {
      for (int j = 0; j < count.length; j++) {
        count[j][k] -= 1;
      }
    }
    return result + 1;
  }

  static void incrementCountRow(int i, int[][] count) {
    for (int k = 0; k < count[0].length; k++) {
      count[i][k] += 1;
    }
  }

  static void incrementCountCoulmn(int i, int[][] count) {
    for (int k = 0; k < count.length; k++) {
      count[k][i] += 1;
    }
  }

  static int gcd(int a, int b) {

    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }

    if (a == b) {
      return a;
    }

    if (a > b) {
      return gcd(a - b, b);
    } else {
      return gcd(b - a, a);
    }
  }

  public static void main(String[] args) {

    int[][] mat =
        new int[][] {
          {192, 2272, 735, 1264, 2244},
          {4, 3136, 63, 288, 3069},
          {106, 1824, 42, 1296, 2871},
          {84, 2112, 1890, 720, 660},
          {82, 960, 672, 288, 3234},
          {144, 2624, 1596, 160, 924},
          {136, 1824, 2058, 864, 2871}
        };
    System.out.println(solve(7, 5, mat));
  }
}
