package com.mali.ds.arrays;

import java.util.*;

/* https://leetcode.com/contest/biweekly-contest-106/problems/find-a-good-subset-of-the-matrix/*/
public class FindaGoodSubsetofTheMatrix {

  public static List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < m; i++) {
      int a = 0;
      int s = 1;
      for (int j = 0; j < n; j++) {
        a += grid[i][j] * s;
        s *= 2;
      }
      if (a == 0) return Collections.singletonList(i);
      map.putIfAbsent(a, i);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
        if (!entry.getKey().equals(entry2.getKey())
            && isPossible(entry.getKey(), entry2.getKey())) {
          if (entry.getValue() < entry2.getValue())
            return Arrays.asList(entry.getValue(), entry2.getValue());
          return Arrays.asList(entry2.getValue(), entry.getValue());
        }
      }
    }

    return new ArrayList<>();
  }

  public static boolean isPossible(int i, int j) {
    while (i > 0 && j > 0) {
      if (i % 2 == 1 && j % 2 == 1) return false;
      i /= 2;
      j /= 2;
    }

    return true;
  }

  public static void main(String[] args) {

    int[][] grid = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 1, 1}};
    goodSubsetofBinaryMatrix(grid);
  }
}
