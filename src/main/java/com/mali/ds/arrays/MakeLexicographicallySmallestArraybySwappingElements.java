package com.mali.ds.arrays;

import java.util.*;

/* https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
 * medium tough
 * */
public class MakeLexicographicallySmallestArraybySwappingElements {

  static class Tuple {

    int index;
    int value;

    public Tuple(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
    int len = nums.length;

    Tuple[] tuples = new Tuple[len];
    for (int i = 0; i < len; i++) {
      tuples[i] = new Tuple(i, nums[i]);
    }

    Arrays.sort(tuples, Comparator.comparingInt(a -> a.value));
    Tuple current = tuples[0];
    int[] ans = new int[len];
    List<Integer> indexes = new ArrayList<>();
    List<Integer> values = new ArrayList<>();
    indexes.add(current.index);
    values.add(current.value);
    for (int i = 1; i < len; i++) {

      while (i < len && tuples[i].value - current.value <= limit) {
        indexes.add(tuples[i].index);
        values.add(tuples[i].value);
        current = tuples[i];
        i++;
      }
      Collections.sort(indexes);
      Collections.sort(values);
      for (int j = 0; j < indexes.size(); j++) {
        ans[indexes.get(j)] = values.get(j);
      }
      indexes = new ArrayList<>();
      values = new ArrayList<>();
      if (i < len) {
        current = tuples[i];
        indexes.add(current.index);
        values.add(current.value);
      }
    }
    Collections.sort(indexes);
    Collections.sort(values);
    for (int j = 0; j < indexes.size(); j++) {
      ans[indexes.get(j)] = values.get(j);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1, 7, 6, 18, 2, 1};
    int limit = 3;
    System.out.println(lexicographicallySmallestArray(nums, limit));
  }
}
