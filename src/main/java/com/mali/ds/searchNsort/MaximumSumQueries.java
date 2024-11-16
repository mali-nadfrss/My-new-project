package com.mali.ds.searchNsort;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/contest/weekly-contest-349/problems/maximum-sum-queries/ */
public class MaximumSumQueries {

  static class Pair {

    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {

    List<Pair> p = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      p.add(new Pair(nums1[i], nums2[i]));
    }
    p.sort(
        (o1, o2) -> {
          if ((o2.x + o2.y) == (o1.x + o1.y)) {
            return 0;
          } else return (o2.x + o2.y) - (o1.x + o1.y);
        });
    int[] ans = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int j = 0;
      while (j < p.size()) {
        if (p.get(j).x >= queries[i][0] && p.get(j).y >= queries[i][1]) {
          ans[i] = p.get(j).x + p.get(j).y;
          break;
        }
        j++;
      }
      if (j >= p.size()) {
        ans[i] = -1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums1 = {2, 1}, nums2 = {2, 3};
    int[][] queries = {{3, 3}};
    maximumSumQueries(nums1, nums2, queries);
  }
}
