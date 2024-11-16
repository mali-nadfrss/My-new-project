package com.mali.ds.bitManipulation;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/contest/weekly-contest-332/problems/substring-xor-queries/ */
public class SubstringXORQueries {

  public static int[][] substringXorQueries(String s, int[][] queries) {

    Map<Long, int[]> map = new HashMap<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      long k = 0;
      if (s.charAt(i) == '0') {
        map.putIfAbsent(k, new int[] {i, i});
        continue;
      }
      for (int j = i; j < len; j++) {
        if (s.charAt(j) == '1') {
          k += 1;
        }
        map.putIfAbsent(k, new int[] {i, j});
        k = k << 1;
      }
    }

    int[][] result = new int[queries.length][2];

    for (int i = 0; i < queries.length; i++) {
      long k = queries[i][0] ^ queries[i][1];
      if (map.get(k) != null) {
        result[i] = map.get(k);
      } else {
        result[i] = new int[] {-1, -1};
      }
    }
    return result;
  }

  public static void main(String[] args) {
    substringXorQueries("101101", new int[][] {{0, 5}, {1, 2}});
  }
}
