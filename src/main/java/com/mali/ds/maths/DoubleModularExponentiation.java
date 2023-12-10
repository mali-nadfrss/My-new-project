package com.mali.ds.maths;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/contest/weekly-contest-375/problems/double-modular-exponentiation/ */
public class DoubleModularExponentiation {

  public static List<Integer> getGoodIndices(int[][] variables, int target) {

    List<Integer> ans = new ArrayList<>();
    int len = variables.length;

    for (int i = 0; i < len; i++) {

      int a = variables[i][0];
      int b = variables[i][1];
      int c = variables[i][2];
      int m = variables[i][3];

      int k = a;
      for (int j = 1; j < b; j++) {
        k *= a;
        k %= 10;
      }
      k = k % 10;
      int l = k;
      for (int j = 1; j < c; j++) {
        l *= k;
        l %= m;
      }
      l %= m;
      if (l == target) ans.add(i);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[][] variables = {{2,2,3,2},{1,3,3,2},{3,2,2,3},{3,1,2,3},{1,2,3,1},{2,2,2,2},{2,1,3,1},{3,2,2,2},{2,1,3,1},{3,3,1,3}}
            ;
    int target = 0;
    getGoodIndices(variables, target);
  }
}
