package com.mali.ds.trees.segment;

import java.util.HashMap;
import java.util.Map;

/*https://leetcode.com/problems/range-frequency-queries/description/ */
public class RangeFrequencyQueries {

  Map<Integer, Integer>[] tree;
  int count;

  public RangeFrequencyQueries(int[] arr) {
    this.count = arr.length;
    this.tree = new Map[count * 4];
    for (int i = 0; i < count; i++) {
      update(arr, 0, count - 1, 0);
    }
  }

  public static void main(String[] args) {
    int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
    RangeFrequencyQueries queries = new RangeFrequencyQueries(arr);
    System.out.println(queries.query(1, 2, 4));
    System.out.println(queries.query(0, 11, 33));
  }

  public void update(int[] nums, int start, int end, int node) {
    if (start == end) {
      if (tree[node] == null) tree[node] = new HashMap<>();
      tree[node].put(nums[start], 1);
      return;
    }
    int mid = (start + end) / 2;
    update(nums, mid + 1, end, 2 * node + 2);
    update(nums, start, mid, 2 * node + 1);
    tree[node] = addMaps(tree[2 * node + 1], tree[2 * node + 2]);
  }

  public Map<Integer, Integer> addMaps(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    Map<Integer, Integer> result = new HashMap<>();
    if (map1 != null)
      for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
        result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + entry.getValue());
      }
    if (map2 != null)
      for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
        result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + entry.getValue());
      }
    return result;
  }

  public int query(int left, int right, int value) {
    return query(left, right, value, 0, count - 1, 0);
  }

  public int query(int left, int right, int value, int start, int end, int node) {

    if (left > end || right < start) return 0;
    if (left <= start && right >= end) {
      if (tree[node] == null || tree[node].get(value) == null) return 0;
      return tree[node].get(value);
    }
    int mid = (start + end) / 2;
    return query(left, right, value, start, mid, 2 * node + 1)
        + query(left, right, value, mid + 1, end, 2 * node + 2);
  }
}
