package com.mali.ds.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* https://leetcode.com/contest/weekly-contest-359/problems/maximize-the-profit-as-the-salesman/ */
public class MaximizetheProfitAstheSalesman {

  public static int maximizeTheProfit(int n, List<List<Integer>> offers) {

    TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
    offers.sort(
        (a, b) -> {
          if (a.get(1).equals(b.get(1))) {
            if (a.get(0).equals(b.get(0))) return b.get(2).compareTo(a.get(2));
            return b.get(0).compareTo(a.get(0));
          } else return b.get(1).compareTo(a.get(1));
        });

    for (List<Integer> offer : offers) {
      map.putIfAbsent(offer.get(0), new ArrayList<>());
      map.get(offer.get(0)).add(offer);
    }

    int[] dp = new int[n];
    int ans = 0;
    for (List<Integer> list : offers) {
      ans = Math.max(recursion(map, list.get(1), list.get(2), dp), ans);
    }

    return ans;
  }

  static int recursion(TreeMap<Integer, List<List<Integer>>> map, int start, int sum, int[] dp) {

    if (map.ceilingKey(start + 1) == null) {
      return sum;
    }

    if (dp[map.ceilingKey(start + 1)] > 0) {
      return dp[start];
    }

    int val = 0;
    for (List<Integer> list : map.get(map.ceilingKey(start + 1))) {
      val = Math.max(val, recursion(map, list.get(1), sum + list.get(2), dp));
    }
    val = Math.max(val, recursion(map, start + 1, sum, dp));
    return dp[start] = val;
  }

  public static void main(String[] args) {
    int[][] arr = 
    {{1,2,5},{4,6,7},{0,2,4},{4,4,1},{2,4,7},{0,5,4},{2,3,7},{3,4,6},{1,2,9},{2,5,8}};

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
