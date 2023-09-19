package com.mali.ds.dp;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-359/problems/maximize-the-profit-as-the-salesman/ */
public class MaximizetheProfitAstheSalesman {

  public static int maximizeTheProfit(int n, List<List<Integer>> offers) {

    Map<Integer, List<List<Integer>>> map = new HashMap<>();

    for (List<Integer> offer : offers) {
      map.putIfAbsent(offer.get(0), new ArrayList<>());
      map.get(offer.get(0)).add(offer);
    }

    int[] dp = new int[n + 2];

    for (int i = n; i >= 0; i--) {
      dp[i] = dp[i + 1];
      if (map.get(i) != null) {
        for (List<Integer> list : map.get(i)) {
          dp[i] = Math.max(dp[i], list.get(2) + dp[list.get(1) + 1]);
        }
      }
    }

    return dp[0];
  }

  static int count;


  int naive(Map<Integer, List<List<Integer>>> map, int index){

    if (index == count) return 0;
    //if we choose NOT to consider sales at starting at current index, just go to next index sales
    int val = naive(map, index+1);

    //if we choose to consider then, for each sales pitch we need to take its value and
    //add sales pitch which is greater than current sales end value
    if (map.get(index) != null){
      for (List<Integer> sales: map.get(index)) {
        val = Math.max(val, sales.get(2)+naive(map, sales.get(1)+1));
      }
    }
    return val;
  }

  static int recursion(TreeMap<Integer, List<List<Integer>>> map, int end, int[] dp) {

    if (end >= count) {
      return 0;
    }

    if (dp[end] > 0) {
      return dp[end];
    }

    int val = 0;

    val = Math.max(val, recursion(map, end + 1, dp));

    if (map.get(end) != null)
      for (List<Integer> list : map.get(end)) {
        val = Math.max(val, list.get(2) + recursion(map, list.get(1) + 1, dp));
      }

    return dp[end] = val;
  }

  public static void main(String[] args) {
    int[][] arr = {{0, 0, 5}, {3, 3, 1}, {1, 2, 5}, {0, 0, 7}};

    List<List<Integer>> in = new ArrayList<>();

    for (int[] a : arr) {
      List<Integer> l = new ArrayList<>();
      for (int i : a) {
        l.add(i);
      }
      in.add(l);
    }
    maximizeTheProfit(10, in);
  }
}
