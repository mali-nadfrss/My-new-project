package com.mali.ds.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/reduce-array-size-to-the-half/ */
public class ReduceArraySizetoTheHalf {

  public static int minSetSize(int[] arr) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i : arr) {
      map.putIfAbsent(i, 0);
      map.put(i, map.get(i) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pq.add(entry.getValue());
    }
    int size = arr.length;
    int ans = 0;
    int cur = 0;

    while (!pq.isEmpty()) {
      cur += pq.poll();
      ans += 1;
      if (cur >= size / 2) return ans;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 1, 1, 2, 2};
    System.out.println(minSetSize(arr));

    String wildCard = "customer";
    String input = "${customer} default notification";
    String replacement = "novartis";
    StringBuilder sb = new StringBuilder();
    sb.append("(\\$\\{)");
    sb.append(wildCard);
    sb.append("+(})");
    System.out.println(input.replaceAll(sb.toString(), replacement));
  }
}
