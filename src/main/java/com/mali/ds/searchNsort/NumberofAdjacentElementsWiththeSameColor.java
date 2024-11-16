package com.mali.ds.searchNsort;

/* https://leetcode.com/contest/weekly-contest-344/problems/number-of-adjacent-elements-with-the-same-color/ */
public class NumberofAdjacentElementsWiththeSameColor {

  public static int[] colorTheArray(int n, int[][] queries) {

    int len = queries.length;

    int[] ans = new int[len];
    int[] ele = new int[n];
    ele[queries[0][0]] = queries[0][1];
    for (int i = 1; i < len; i++) {
      int count = 0;
      ans[i] = ans[i - 1];
      int index = queries[i][0];
      int clr = queries[i][1];
      if (ele[index] == clr) {
        ans[i] = ans[i - 1];
        continue;
      }
      if (index > 0 && ele[index] != 0 && ele[index] == ele[index - 1]) {
        count--;
      }
      if (index + 1 < n && ele[index] != 0 && ele[index] == ele[index + 1]) {
        count--;
      }
      ele[index] = clr;
      if (index > 0 && ele[index] == ele[index - 1]) {
        count++;
      }
      if (index + 1 < n && ele[index] == ele[index + 1]) {
        count++;
      }
      ans[i] += count;
    }
    return ans;
  }

  public static void main(String[] args) {

    int n = 4;
    int[][] queries = {{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}};
    colorTheArray(n, queries);
  }
}
