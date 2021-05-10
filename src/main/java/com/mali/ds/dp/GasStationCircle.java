package com.mali.ds.dp;
/*
https://leetcode.com/problems/gas-station/discuss/1197683/Lessons-learned
medium
 */
public class GasStationCircle {
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0;
    int currentTotal = 0;
    int start = 0;
    for (int i = 0; i < gas.length; ++i) {
      int mileage = gas[i] - cost[i];
      total = total + mileage;
      currentTotal = currentTotal + mileage;
      if (currentTotal < 0) {
        start = i + 1;
        currentTotal = 0;
      }
    }
    return total < 0 ? -1 : start;
  }

  public static void main(String[] args) {
    int[] gas = {1, 2, 3, 4, 5};
    int[] cost = {3, 4, 5, 1, 2};
    System.out.println(canCompleteCircuit(cost, gas));
  }
}
