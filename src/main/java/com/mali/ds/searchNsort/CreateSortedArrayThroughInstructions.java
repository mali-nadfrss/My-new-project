package com.mali.ds.searchNsort;

import java.util.LinkedList;

/* https://leetcode.com/problems/create-sorted-array-through-instructions/
 * Hard */
public class CreateSortedArrayThroughInstructions {

  public static int createSortedArray(int[] instructions) {
    LinkedList<Integer> l = new LinkedList<>();
    int ans = 0;
    for (int i : instructions) {
      ans = ans + binarySearch(l, i);
    }

    return (ans % (int) (Math.pow(10, 9) + 7));
  }

  static int binarySearch(LinkedList<Integer> l, int i) {

    int start = 0;
    int end = l.size() - 1;
    int size = l.size();
    if (l.isEmpty()) {
      l.add(i);
      return 0;
    }
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (l.get(mid) <= i) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    l.add(start, i);
    return Math.min(start, size - start);
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 3, 3, 2, 4, 2, 1, 2};
    System.out.println(createSortedArray(nums));
  }
}
