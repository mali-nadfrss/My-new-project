package com.mali.ds.trees;

/* https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/ */
public class SegmentedTree {

  void updateTree(int[] st, int val, int index, int low, int high, int pos) {

    if (low == high) {
      st[pos] += val;
      return;
    }

    int mid = (low + high) / 2;
    if (index <= mid) updateTree(st, val, index, low, mid, 2 * pos + 1);
    else updateTree(st, val, index, mid + 1, high, 2 * pos + 2);
    st[pos] = st[2 * pos + 1] + st[2 * pos + 2];
  }

  void createTree(int[] nums, int[] st, int low, int high, int pos) {
    if (low == high) {
      st[pos] = nums[low];
      return;
    }
    int mid = (low + high) / 2;
    createTree(nums, st, low, mid, 2 * pos + 1);
    createTree(nums, st, mid + 1, high, 2 * pos + 2);
    st[pos] = Math.min(st[2 * pos + 1], st[2 * pos + 2]);
  }

  int searchTree(int[] st, int qlow, int qhigh, int low, int high, int pos) {
    if (qlow <= low && qhigh >= high) {
      return st[pos]; // total overlap
    }
    if (qlow > high || qhigh < low) {
      return Integer.MAX_VALUE; // no overlap
    }
    int mid = (low + high) / 2;
    return Math.min(
        searchTree(st, qlow, qhigh, low, mid, 2 * pos + 1),
        searchTree(st, qlow, qhigh, mid + 1, high, 2 * pos + 2));
  }
}
