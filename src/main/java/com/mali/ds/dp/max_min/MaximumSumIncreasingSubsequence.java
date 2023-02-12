package com.mali.ds.dp.max_min;

/* https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/ */
public class MaximumSumIncreasingSubsequence {

  static int maxSumIS(int arr[], int n) {
    int[] sumArr = new int[n];
    for (int i = 0; i < n; i++) {
      sumArr[i] = arr[i];
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j] && sumArr[i] < sumArr[j] + arr[i]) {
          sumArr[i] = sumArr[j] + arr[i];
        }
      }
    }

    int ans = 0;
    for (int i : sumArr) {
      ans = Math.max(ans, i);
    }
    return ans;
  }

  public static void main(String[] args) {
    maxSumIS(new int[]{1, 101, 2, 3, 100, 4, 5},7 );
  }
}
