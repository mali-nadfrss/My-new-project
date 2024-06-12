package com.mali.ds.maths;

import java.util.Arrays;

/*https://leetcode.com/contest/weekly-contest-392/problems/minimum-operations-to-make-median-of-array-equal-to-k/ */
public class MinimumOperationstoMakeMedianofArrayEqualtoK {

  public static long minOperationsToMakeMedianK(int[] nums, int k) {

    Arrays.sort(nums);
    int count = nums.length;
    int ans = 0;
    if (count % 2 == 0) {
      int v = (int) Math.ceil((nums[count / 2 - 1] + nums[count / 2]) / 2.0);
      if (v < k) {
        ans += 2*(k-v);
        int i = count / 2 + 1;
        while (i < count && nums[i] < k) {
          ans += k - nums[i++];
        }
      } else if (v > k) {
        ans += 2*(v-k);
        int i = count / 2 + 1;
        while (i >= 0 && nums[i] > k) {
          ans += nums[i--] - k;
        }
      }
    } else {
      int i = count / 2;
      if (nums[i] < k) {
        while (i < count && nums[i] < k) {
          ans += k - nums[i++];
        }
      } else if (nums[i] > k) {
        while (i >= 0 && nums[i] > k) {
          ans += nums[i--] - k;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {98, 52};
    int k = 82;
    minOperationsToMakeMedianK(nums, k);
  }
}
