package com.mali.ds.bitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* https://leetcode.com/contest/weekly-contest-360/problems/minimum-operations-to-form-subsequence-with-target-sum/ */
public class MinimumOperationstoFormSubsequenceWithTargetSum {

  public static int minOperations(List<Integer> nums, int target) {

    long sum = 0;
    int ans = 0;
    int[] numBit = new int[32];
    int[] tarBit = new int[32];
    int count = 0;

    int tempTarget = target;
    while (tempTarget > 0) {
      tarBit[tempTarget >> 1]++;
      tempTarget >>= 1;
    }
    Collections.sort(nums);
    for (int i = 0; i < nums.size(); i++) {
      sum += nums.get(i);
      for (int j = 0; j < 32; j++) {
        if (nums.get(i) >> j == 1) {
          numBit[j]++;
        }
      }
    }
    if (sum < target) return -1;
    sum = 0;
    for (int i = 0; i < 32; i++) {
      if (tarBit[i] == 1) {
        if (numBit[i] >= 1) {
          numBit[i]--;  
        }
        sum += (long) numBit[i] << i;
        if (sum >= (long) tarBit[i] <<i) {
          sum -= (long) tarBit[i] <<i;
        } else {
          boolean found = false;
          for (int j = i + 1; j < 32; j++) {
            if (numBit[j] == 1) {
              found = true;
              numBit[j]--;
              for (int k = j - 1; k >= i; k--) {
                numBit[k]++;
                count++;
              }
            }
          }
          if (!found) return -1;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 8};
    List<Integer> list = new ArrayList<>();
    for (int i : nums) {
      list.add(i);
    }
    int target = 7;

    minOperations(list, target);
  }
}
