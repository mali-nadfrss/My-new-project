package com.mali.ds.algorithms;

public class Knapsack {


  int bruteForce(int[] weights, int[] profits, int capacity, int index) {
    if (capacity <= 0 || index >= weights.length) {
      return 0;
    }

    int profit1 = 0;
    if (weights[index] <= capacity) {
      profit1 = profits[index] + bruteForce(weights, profits, capacity - weights[index], index);
    }
    int profit2 = bruteForce(weights, profits, capacity, index + 1);
    return Integer.max(profit1, profit2);
  }

  int normal(int[] weights, int[] profits, int[][] dp, int capacity, int currentIndex) {
    if (capacity < 0 || currentIndex >= weights.length) {
      return 0;
    }
    if (dp[currentIndex][capacity] != -1) {
      return dp[currentIndex][capacity];
    }
    int profit1 = 0;
    if (weights[currentIndex] <= capacity) {
      profit1 =
          profits[currentIndex]
              + normal(weights, profits, dp, capacity - weights[currentIndex], currentIndex + 1);
    }
    int profit2 = normal(weights, profits, dp, capacity, currentIndex + 1);
    dp[currentIndex][capacity] = Integer.max(profit1, profit2);
    return dp[currentIndex][capacity];
  }



}
