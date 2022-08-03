package com.mali.ds.arrays;

import java.util.*;

/* https://leetcode.com/problems/relative-sort-array/
 * easy 1122 */
public class RelativeSortArray {

  public static int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr2.length; i++) {
      map.put(arr2[i], i);
    }

    List<Integer> list = new ArrayList<>();
    for (int i : arr1) {
      list.add(i);
    }

    Comparator<Integer> comp =
        (i, j) -> {
          if (map.get(i) != null && map.get(j) != null) {
            return map.get(i) - map.get(j);
          } else if (map.get(i) != null) {
            return -1;
          } else return 1;
        };
    list.sort(comp);
    int[] ans = new int[arr1.length];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] values = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    int[] values1 = {2, 1, 4, 3, 9, 6};
    System.out.println(relativeSortArray(values, values1));
  }
}
