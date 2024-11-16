package com.mali.ds.dp.max_min;

/* https://leetcode.com/problems/count-of-integers/description */
public class CountofIntegers {

  static final int MOD = 1000000007;
  static int min;
  static int max;

  // recursion solution
  public static int count(String num1, String num2, int min_sum, int max_sum) {
    min = min_sum;
    max = max_sum;
    int dp[][][] = new int[22][2][max];
    int ans1 = findCount(0, num1, 0, true, dp);
    dp = new int[22][2][max];
    int ans2 = findCount(0, num2, 0, true, dp);
    int sum = 0;
    for (char c : num1.toCharArray()) {
      sum += c - '0';
    }
    if (sum >= min && sum <= max) {
      return ((ans2 - ans1) % MOD + 1) % MOD;
    }
    return (ans2 - ans1) % MOD;
  }

  static int findCount(int index, String num, int sum, boolean isEnd, int[][][] dp) {
    if (sum > max || index > num.length()) {
      return 0;
    }
    if (index == num.length()) {
      return sum >= min ? 1 : 0;
    }
    if (dp[index][isEnd ? 1 : 0][sum] > 0) return dp[index][isEnd ? 1 : 0][sum];
    int count = 0;
    int end = 9;
    if (isEnd) {
      end = num.charAt(index) - '0';
    }
    for (int i = 0; i <= end; i++) {
      count += findCount(index + 1, num, sum + i, isEnd && i == num.charAt(index) - '0', dp);
    }
    return dp[index][isEnd ? 1 : 0][sum] = count;
  }

  public static void main(String[] args) {
    System.out.println(count("1", "12", 1, 8));
  }
}
