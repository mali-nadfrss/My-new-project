package com.mali.ds.trees.segmentTree;

import java.util.*;

/* https://leetcode.com/problems/maximum-sum-queries/description/ */
public class MaximumSumQueries {

  public static int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {

    int len = nums1.length;
    int[][] arr = new int[len][2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      arr[i][0] = nums1[i];
      arr[i][1] = nums2[i] + nums1[i];
      map.put(nums1[i], i);
    }

    Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
    ArrayList<Integer>[] mst = new ArrayList[4 * len];
    build(0, len - 1, 0, mst, arr);
    int qlen = queries.length;
    int[] ans = new int[qlen];

    for (int i = 0; i < qlen; i++) {
      int res = query(map.get(queries[i][0]), len - 1, 0, len - 1, mst, 0);
      ans[i] = res >= queries[i][1] ? res : -1;
    }
    return ans;
  }

  static void build(int pos, int high, int low, ArrayList<Integer>[] mst, int[][] arr) {
    if (high == low) {
      mst[pos] = new ArrayList<>();
      mst[pos].add(arr[low][1]);
      return;
    }
    int mid = (high + low) / 2;
    build(2 * pos + 1, mid, low, mst, arr);
    build(2 * pos + 2, high, mid + 1, mst, arr);
    mst[pos] = new ArrayList<>();
    mst[pos].addAll(mst[2 * pos + 1]);
    mst[pos].addAll(mst[2 * pos + 2]);
    Collections.sort(mst[pos]);
  }

  static int query(int qlow, int qhigh, int low, int high, ArrayList<Integer>[] mst, int index) {

    if (low > qhigh || qlow > high) return -1;

    if (qlow <= low && qhigh >= high) {
      return mst[index].get(mst[index].size() - 1);
    }
    int mid = (high + low) / 2;
    return Math.max(
        query(qlow, qhigh, low, mid, mst, 2 * index + 1),
        query(qlow, qhigh, mid + 1, high, mst, 2 * index + 2));
  }

  public static void main(String[] args) {
    int[] nums1 = {3, 2, 5}, nums2 = {2, 3, 4};
    int[][] queries = {{4, 4}, {3, 2}, {1, 1}};
    int[] ans = {6, 10, 7};

    maximumSumQueries(nums1, nums2, queries);
  }
}
