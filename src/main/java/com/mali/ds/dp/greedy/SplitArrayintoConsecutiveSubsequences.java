package com.mali.ds.dp.greedy;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 * medium */
public class SplitArrayintoConsecutiveSubsequences {
  public static boolean isPossible(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    Map<Integer, Integer> jobMap = new HashMap<>();

    for (int i : nums) {
      if (map.getOrDefault(i, 0) <= 0) continue;

      if (jobMap.getOrDefault(i, 0) > 0) {
        jobMap.put(i, jobMap.getOrDefault(i,0)-1);
        jobMap.put(i + 1, jobMap.getOrDefault(i+1,0)+1);
        map.put(i, map.getOrDefault(i, 0) - 1);
      }

      else if (map.getOrDefault(i + 1, 0) > 0 && map.getOrDefault(i + 2, 0) > 0) {
        map.put(i, map.getOrDefault(i, 0) - 1);
        map.put(i + 1, map.getOrDefault(i + 1, 0) - 1);
        map.put(i + 2, map.getOrDefault(i + 2, 0) - 1);
        jobMap.put(i + 3, jobMap.getOrDefault(i+3,0)+1);
      }

      else return false;
    }

    return true;
  }

  public static void main(String[] args) {

    System.out.print(isPossible(new int[] {1, 2, 3, 4, 5, 4}));
  }
}
