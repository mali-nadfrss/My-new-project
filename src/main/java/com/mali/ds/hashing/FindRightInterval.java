package com.mali.ds.hashing;

import com.mali.ds.design.DataStreamasDisjointIntervals;

import java.util.Arrays;
import java.util.TreeMap;

/* https://leetcode.com/problems/find-right-interval/ */
public class FindRightInterval {

  public static int[] findRightInterval(int[][] intervals) {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    int len = intervals.length;
    int[] ans = new int[len];

    int j = 0;
    for (int[] i : intervals) {
      map.put(i[0], j++);
    }

    for (int i = 0; i < len; i++) {
      Integer k = map.ceilingKey(intervals[i][1]);
      if (k == null) ans[i] = -1;
      else ans[i] = map.get(k);
    }

    return ans;
  }

  public static void main(String[] args) {

    int[][] k = new int[][] {{3, 4}, {2, 3}, {1, 2}};

    System.out.println(findRightInterval(k));
  }
}
