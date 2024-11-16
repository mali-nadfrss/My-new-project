package com.mali.ds.trees.segmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* https://www.geeksforgeeks.org/merge-sort-tree-smaller-or-equal-elements-in-given-row-range/ */
public class SmallerorEqualElementsinGivenRowRange {

  public static void main(String[] args) {
    Integer ar[][] = {{2, 4, 5}, {3, 4, 9}, {6, 8, 10}};

    int queries[][] = {{0, 1, 5}, {1, 2, 1}, {0, 2, 6}};
    findSmallerElements(ar, queries);
  }

  public static int[] findSmallerElements(Integer[][] arr, int[][] queries) {

    int len = arr.length;
    List<Integer>[] mst = new ArrayList[4 * len];
    buildTree(mst, arr, len - 1, 0, 0);
    int[] ans = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      ans[i] = query(mst, len - 1, 0, queries[i][0], queries[i][1], queries[i][2], 0);
    }
    return ans;
  }

  static int query(List<Integer>[] mst, int high, int low, int ql, int qh, int search, int pos) {

    if (ql > high || qh < low) return 0;

    if (ql >= low && qh <= high) {
      return find(mst[pos], search);
    }
    int mid = (high + low) >> 1;
    int count = 0;
    if (qh <= mid) {
      count += query(mst, mid, low, ql, qh, search, 2 * pos + 1);
    } else if (ql > mid) {
      count += query(mst, mid + 1, low, ql, qh, search, 2 * pos + 2);
    } else {
      count += query(mst, mid + 1, low, ql, qh, search, 2 * pos + 2);
      count += query(mst, mid, low, ql, qh, search, 2 * pos + 1);
    }
    return count;
  }

  static int find(List<Integer> list, int search) {
    int low = 0;
    int high = list.size();
    while (high > low) {
      int mid = low + (high - low) / 2;
      if (list.get(mid) > search) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return high;
  }

  static void buildTree(List<Integer>[] mst, Integer[][] arr, int high, int low, int pos) {

    if (high == low) {
      mst[pos] = new ArrayList<>(Arrays.asList(arr[low]));
      return;
    }

    int mid = (high - low) / 2;
    buildTree(mst, arr, mid, low, 2 * pos + 1);
    buildTree(mst, arr, high, mid + 1, 2 * pos + 2);
    List<Integer> a = new ArrayList<>();
    if (mst[2 * pos + 1] != null) a.addAll(mst[2 * pos + 1]);
    if (mst[2 * pos + 2] != null) a.addAll(mst[2 * pos + 2]);
    a.sort(Comparator.comparingInt(o -> o));
    mst[pos] = a;
  }
}
