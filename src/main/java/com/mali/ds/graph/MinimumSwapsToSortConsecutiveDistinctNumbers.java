package com.mali.ds.graph;

import java.util.Arrays;
import java.util.HashMap;

/* https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/yogi-and-his-steps-65b27a4b/*/
/* Your task is to determine the minimum number of steps that
is required to sort the data in increasing or decreasing order. */
public class MinimumSwapsToSortConsecutiveDistinctNumbers {

  static int minimumSwaps(int[] arr) {
    int ans = 0;
    int[] visited = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      visited[i] = arr[i];
    }
    Arrays.sort(visited);
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(i, arr[i]);
    }
    for (int i = 0; i < visited.length; i++) {
      if (visited[i] != arr[i]) {
        int j = arr[i];
      }
    }
    return ans;
  }
}
