package com.mali.ds.hashing;

import java.util.Set;
import java.util.TreeSet;

/* https://leetcode.com/contest/weekly-contest-323/problems/longest-square-streak-in-an-array/ */
public class LongestSquareStreakinanArray {

  public static int longestSquareStreak(int[] nums) {

    int ans = -1;
    Set<Long> set = new TreeSet<>();

    for (int i = 0; i < nums.length; i++) {

      set.add((long) nums[i]);
    }

    int count = 0;
    for (long i : set) {
      long j =  i;
      while (true) {
        if (set.contains(j * j)) {
          count +=1;
          j = j * j;
        } else {
          break;
        }
      }
      if (count > 0) {
        ans = Math.max(ans, count + 1);
      }
      count = 0;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(longestSquareStreak(new int[] {4, 3, 6, 16, 8, 2}));
  }
}
