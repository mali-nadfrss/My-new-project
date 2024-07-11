package com.mali.ds.trees.segment;

import java.util.ArrayList;
import java.util.List;

/*https://leetcode.com/problems/peaks-in-array/description/
 * Hard*/
public class PeaksInArray {

  public static List<Integer> countOfPeaks(int[] nums, int[][] queries) {

    int len = nums.length;
    int[] seg = new int[4 * len];

    for (int i = 1; i < len - 1; i++) {
      int val = nums[i] > nums[i - 1] && nums[i] > nums[i + 1] ? 1 : 0;
      if (val > 0) update(0, len - 1, i, val, seg, 1);
    }

    List<Integer> ans = new ArrayList<>();

    for (int[] query : queries) {
      if (query[0] == 2) {
        int i = query[1];
        nums[i] = query[2];
        int val =
            i == 0 || i == len - 1 ? 0 : nums[i] > nums[i + 1] && nums[i] > nums[i - 1] ? 1 : 0;
        update(0, len - 1, i, val, seg, 1);
        --i;
        if (i > 0) {
          val = nums[i] > nums[i + 1] && nums[i] > nums[i - 1] ? 1 : 0;
          update(0, len - 1, i, val, seg, 1);
        }
        i += 2;
        if (i < len - 1) {
          val = nums[i] > nums[i + 1] && nums[i] > nums[i - 1] ? 1 : 0;
          update(0, len - 1, i, val, seg, 1);
        }

      } else {
        ans.add(query(0, len - 1, ++query[1], --query[2], 1, seg));
      }
    }
    return ans;
  }

  public static int query(int start, int end, int left, int right, int node, int[] seg) {
    if (start > right || end < left) {
      return 0;
    }
    if (start == end || start >= left && end <= right) {
      return seg[node - 1];
    }
    int mid = start + (end - start) / 2;
    return query(start, mid, left, right, 2 * node, seg)
        + query(mid + 1, end, left, right, 2 * node + 1, seg);
  }

  public static void update(int start, int end, int index, int val, int[] seg, int node) {
    if (start == end) {
      if (start == index) {
        seg[node - 1] = val;
      }
      return;
    }
    int mid = start + (end - start) / 2;
    if (mid >= index) {
      update(start, mid, index, val, seg, 2 * node);
    } else {
      update(mid+1, end, index, val, seg, 2 * node + 1);
    }
    seg[node - 1] = seg[2 * node] + seg[2 * node - 1];
  }

  public static void main(String[] args) {
    int[] nums = {9, 7, 5, 8, 9};
    int[][] queries = {{2, 0, 2}, {1, 0, 3}, {1, 3, 3}, {2, 3, 5}};
    System.out.println(countOfPeaks(nums, queries));
  }
}
