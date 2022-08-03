package com.mali.ds.bitManipulation;

import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/problems/bitwise-ors-of-subarrays/
 * medium */
public class BitwiseORsofSubarrays {
  public static int subarrayBitwiseORs(int[] arr) {

    Set<Integer> ans = new HashSet<>();
    Set<Integer> res = new HashSet<>();
    Set<Integer> prev = new HashSet<>();
    for (int i : arr) {
      res.add(i);
      for (int k : prev) {
        res.add(i | k);
      }
      ans.addAll(res);
      prev = res;
      res = new HashSet<>();
    }
    return ans.size();
  }

  public static void main(String[] args) {
    System.out.println(subarrayBitwiseORs(new int[] {1, 2, 4}));
  }
}
