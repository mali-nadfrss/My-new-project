package com.mali.ds.searchNsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/contest/weekly-contest-363/problems/maximum-number-of-alloys/ */
public class MaximumNumberofAlloys {

  public static int maxNumberOfAlloys(
      int n,
      int k,
      int budget,
      List<List<Integer>> composition,
      List<Integer> stock,
      List<Integer> cost) {

    long total = 0;
    long stockTotal = 0;
    for (int i = 0; i < cost.size(); i++) {
      stockTotal += stock.get(i) * cost.get(i);
      total += cost.get(i);
    }
    int ans = 0;
    for (List<Integer> compos : composition) {
      int high = 1 + (int) ((budget + stockTotal) / total);
      int low = 0;
      long sum = 0;

      while (high > low) {
        int mid = low + (high - low) / 2;
        sum = 0;
        for (int i = 0; i < compos.size(); i++) {
          sum += Math.max(compos.get(i) * mid * 1l - stock.get(i), 0) * cost.get(i);
        }

        if (sum <= budget) {
          ans = Math.max(ans, mid);
          low = mid + 1;
        } else {
          high = mid;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    int n = 20, k = 20, budget = 71522379;
    Integer[][] composition = {
      {67, 83, 9, 11, 32, 88, 19, 90, 67, 75, 47, 3, 99, 87, 8, 25, 72, 42, 15, 51},
      {6, 66, 54, 56, 88, 31, 91, 45, 66, 83, 86, 11, 70, 99, 81, 11, 9, 46, 82, 5},
      {62, 8, 96, 18, 77, 49, 27, 58, 66, 52, 82, 30, 23, 69, 61, 100, 84, 17, 52, 20},
      {62, 8, 33, 67, 81, 38, 29, 41, 34, 90, 65, 78, 80, 76, 58, 2, 3, 67, 75, 29},
      {91, 37, 79, 20, 44, 98, 5, 100, 89, 16, 45, 46, 60, 36, 69, 20, 78, 84, 14, 45},
      {96, 95, 84, 56, 8, 45, 44, 84, 36, 35, 56, 2, 69, 36, 40, 70, 59, 74, 58, 67},
      {95, 11, 31, 56, 9, 42, 48, 72, 51, 38, 37, 78, 86, 96, 24, 83, 43, 28, 1, 34},
      {92, 91, 95, 50, 56, 98, 27, 54, 47, 71, 25, 2, 47, 42, 55, 4, 46, 86, 61, 16},
      {66, 49, 73, 31, 83, 69, 85, 27, 26, 98, 11, 19, 17, 53, 1, 84, 85, 36, 100, 24},
      {13, 9, 63, 99, 66, 54, 51, 48, 55, 21, 74, 47, 65, 11, 97, 87, 61, 46, 61, 45},
      {32, 13, 75, 16, 71, 47, 17, 51, 93, 12, 49, 80, 8, 14, 73, 97, 52, 79, 69, 97},
      {60, 82, 84, 69, 96, 99, 91, 86, 93, 41, 59, 56, 12, 5, 48, 97, 36, 62, 69, 47},
      {72, 86, 42, 10, 73, 21, 51, 79, 80, 29, 1, 70, 97, 21, 76, 68, 22, 44, 19, 62},
      {42, 24, 59, 6, 60, 34, 88, 80, 2, 82, 23, 31, 22, 85, 46, 9, 41, 56, 69, 42},
      {6, 100, 43, 22, 79, 87, 25, 9, 25, 62, 93, 30, 11, 72, 4, 2, 22, 48, 46, 71},
      {67, 12, 47, 52, 18, 91, 22, 95, 97, 89, 66, 68, 66, 7, 50, 38, 7, 7, 14, 95},
      {95, 76, 10, 32, 3, 26, 60, 6, 34, 99, 48, 97, 73, 27, 1, 16, 34, 14, 39, 67},
      {27, 39, 17, 23, 13, 27, 96, 98, 82, 100, 46, 1, 99, 60, 12, 31, 31, 24, 4, 5},
      {27, 27, 2, 39, 87, 41, 58, 30, 66, 7, 11, 86, 95, 87, 59, 78, 69, 2, 95, 48},
      {87, 52, 98, 66, 72, 97, 65, 41, 39, 93, 24, 96, 59, 4, 13, 70, 59, 53, 3, 62}
    };
    List<List<Integer>> list = new ArrayList<>();
    for (Integer[] arr : composition) {
      list.add(Arrays.asList(arr));
    }
    Integer[]
        stock = {13, 39, 7, 42, 35, 71, 13, 50, 25, 32, 86, 78, 35, 67, 70, 19, 73, 16, 61, 75},
        cost = {43, 58, 5, 26, 41, 86, 82, 41, 96, 25, 43, 50, 61, 56, 90, 62, 5, 94, 19, 95};
    maxNumberOfAlloys(n, k, budget, list, Arrays.asList(stock), Arrays.asList(cost));
  }
}
