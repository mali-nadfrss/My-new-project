package com.mali.ds.dp.mergingIntervals;

/* https://leetcode.com/problems/maximize-win-from-two-segments/description/ */
public class MaximizeWinFromTwoSegments {

  public static int maximizeWin(int[] prizePositions, int k) {

    int len = prizePositions.length;
    int[] dp = new int[len + 1];
    int start = len - 1;
    int end = len - 1;

    for (; start >= 0; ) {
      if (prizePositions[end] - prizePositions[start] <= k) {
        dp[start] = Math.max(dp[start + 1], end - start + 1);
        start--;
      } else {
        end--;
      }
    }

    int ans = 0;
    start = 0;
    end = 0;
    for (; end < len; end++) {
      if (prizePositions[end] - prizePositions[start] <= k) {
        ans = Math.max(ans, end - start + 1 + dp[end + 1]);
      } else {
        start++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(maximizeWin(new int[] {1, 1, 2, 2, 3, 3, 5}, 2));
  }
}
