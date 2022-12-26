package com.mali.ds.trees.bt;

import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-324/problems/cycle-length-queries-in-a-tree/ */
public class CycleLengthQueriesinaTree {

  public static int[] cycleLengthQueries(int n, int[][] queries) {

    int[] ans = new int[queries.length];
    int i = 0;
    for (int[] query : queries) {
      Set<Integer> set = new HashSet<>();
      int k = query[0];
      int m = query[1];
      int count = 0;
      while (k >= 1) {
        set.add(k);
        k = k >> 1;
        count++;
      }
      boolean flag = false;
      while (m >= 1) {
        if (set.contains(m)) {
          flag = true;
        }
        if (flag) count -= 1;
        else count++;
        m = m >> 1;
      }
      ans[i++] = count + 1;
    }
    return ans;
  }

  public static void main(String[] args) {

    int[][] arr = {{5, 3}, {4, 7}, {2, 3}};
    cycleLengthQueries(3, arr);
  }
}
