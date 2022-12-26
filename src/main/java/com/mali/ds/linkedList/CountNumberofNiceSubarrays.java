package com.mali.ds.linkedList;

import java.util.LinkedList;

/* https://leetcode.com/problems/count-number-of-nice-subarrays/ */
public class CountNumberofNiceSubarrays {

  public static int numberOfSubarrays(int[] nums, int k) {

    int ans = 0;
    int start = -1;
    LinkedList<Integer> list = new LinkedList<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 1) {
        list.add(i);
      }
      if (list.size() > k) {
        start = list.removeFirst();
      }
      if (list.size() == k) {
        ans += list.getFirst() - start;
      }
    }

    return ans;
  }

  public static void main(String[] args) {

    int[] nums = {2, 4, 6};
    int k = 1;
    System.out.println(numberOfSubarrays(nums, k));
  }
}
