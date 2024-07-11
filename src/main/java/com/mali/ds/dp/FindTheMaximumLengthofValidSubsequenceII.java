package com.mali.ds.dp;

/*https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/description/ */
public class FindTheMaximumLengthofValidSubsequenceII {

  public static int maximumLength(int[] nums, int k) {

    int len = nums.length;
    int dp[][] = new int[len][k];
    int ans = 0;
    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        int r = (nums[i] + nums[j]) % k;
        dp[i][r] = Math.max(dp[i][r], dp[j][r] + 1);
        ans = Math.max(ans, dp[i][r]);
      }
    }
    return ans + 1;
  }

  public static void main(String[] args) {
    int[] arr = {1, 5, 9, 2, 8};
    System.out.println(maximumLength(arr, 2));
  }
}
