package com.mali.ds.arrays;

/* https://leetcode.com/contest/weekly-contest-316/problems/number-of-subarrays-with-gcd-equal-to-k/*/
public class NumberofSubarraysWithGCDEqualtoK {

  public static int subarrayGCD(int[] nums, int k) {

    int ans = 0;



    for (int j = 0; j < nums.length; j++) {
      int cg = nums[j];
      for (int i = j; i < nums.length; i++) {

        cg = findGCD(cg, nums[i]);

        if (cg == k) {
          ans++;
        } else if (cg < k) {
          break;
        }
      }
    }

    return ans;
  }

  static int findGCD(int a, int b) {
    if (b == 0) return a;
    return findGCD(b, a % b);
  }

  public static void main(String[] args) {
    System.out.println(subarrayGCD(new int[] {9, 3, 1, 2, 6, 3}, 3));
  }
}
