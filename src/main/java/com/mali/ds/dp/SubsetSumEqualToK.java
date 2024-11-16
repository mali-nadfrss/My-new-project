package com.mali.ds.dp;

/* https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos */
public class SubsetSumEqualToK {

  public static boolean subsetSumToK(int n, int k, int arr[]) {
    // Write your code here.

    int[][] dp = new int[n + 1][k + 1];
    for (int i = 0; i < n; i++) {
      dp[i][k] = 1;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= k; j++) {
        if (dp[i][k] == 1) continue;
        if (k - arr[i] < 0) {
          dp[i][k] = dp[i + 1][k];
        } else dp[i][k] = dp[i + 1][k] == 1 || dp[i + 1][k - arr[i]] == 1 ? 1 : 0;
      }
    }
    System.out.println(dp[n-1][k]);
    return recursion(arr, 0, k, new Boolean[n][k + 1]);

    /*Set<Integer> set = new HashSet<>();

    for (int i = 0; i < n; i++) {

      Set<Integer> tset = new HashSet<>();
      tset.add(arr[i]);
      for (int j : set) {
        tset.add(j + arr[i]);
        if (tset.contains(k)) return true;
      }
      set.addAll(tset);
    }

    return false;*/
  }

  static boolean recursion(int[] arr, int i, int k, Boolean[][] dp) {
    if (k == 0) return true;
    if (i >= arr.length || k < 0) return false;
    if (dp[i][k] != null) return dp[i][k];
    return dp[i][k] = recursion(arr, i + 1, k, dp) || recursion(arr, i + 1, k - arr[i], dp);
  }

  public static void main(String[] args) {

    int n = 4, k = 5;
    int[] arr = {4, 3, 2, 1};

    System.out.println(subsetSumToK(n, k, arr));
  }
}
