package com.mali.ds.searchNsort;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* https://leetcode.com/problems/range-frequency-queries/ */
public class RangeFrequencyQueries {

  Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();

  public RangeFrequencyQueries(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      map.computeIfAbsent(arr[i], v -> new TreeMap<>());
      map.get(arr[i]).put(i, map.get(arr[i]).size());
    }
  }

  public int query(int left, int right, int value) {
    TreeMap<Integer, Integer> map = this.map.get(value);
    if (map == null || map.size() == 0) return 0;
    Integer k = map.ceilingKey(left);
    Integer l = map.floorKey(right);
    if (k == null || l == null) return 0;
    return map.get(l) - map.get(k) + 1;
  }

  public static void main(String[] args) {

    /* ["RangeFreqQuery","query","query","query","query"]
      [[[1,1,1,2,2]],[0,1,2],[0,2,1],[3,3,2],[2,2,1]] */

    int[] arr = new int[] {1,1,1,2,2};
    RangeFrequencyQueries rf = new RangeFrequencyQueries(arr);
    System.out.println(rf.query(0, 1, 2));
    System.out.println(rf.query(0, 2, 1));
    System.out.println(rf.query(3, 3, 2));
    System.out.println(rf.query(2, 2, 1));
  }
}
