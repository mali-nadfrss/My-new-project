package com.mali.codeforces;

public class FillingTheGrid {

  static int fillTheGrid(int n, int k) {

    int mod = (int) (Math.pow(10, 9) + 7);
    int cells = (n * n) % mod;
    int ans = (((2 * (cells - n)) % mod) * k) % mod-1;
    System.out.println(ans);

      return ans;
  }

  public static void main(String[] args) {
    fillTheGrid(123, 456789);
  }
}
