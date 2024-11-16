package com.mali.ds.trees.segmentTree;

/* https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/?purpose=signup&source=practice&update=google */
public class RangeMinimumQuery {

  static void buildTree(int[] mst, int high, int low, int index, int[] arr) {

    if (high == low) {
      mst[index] = arr[low];
      return;
    }
    int mid = (low + high) / 2;
    buildTree(mst, mid, low, 2 * index + 1, arr);
    buildTree(mst, high, mid + 1, 2 * index + 2, arr);
    mst[index] = Math.min(mst[2 * index + 1], mst[2 * index + 2]);
  }

  static void update(int[] mst, int high, int low, int index, int val, int pos) {
    if (low == high) {
      mst[index] = val;
      return;
    }
    int mid = (low + high) / 2;
    if (pos <= mid) {
      update(mst, mid, low, 2 * index + 1, val, pos);
    } else {
      update(mst, high, mid + 1, 2 * index + 2, val, pos);
    }
    mst[index] = Math.min(mst[2 * index + 1], 2 * index + 2);
  }

  static int query(int[] mst, int high, int low, int qhigh, int qlow, int index) {

    if (high <= qhigh && low >= qlow) {
      return mst[index];
    }
    if (low > qhigh || high < qlow) {
      return Integer.MAX_VALUE;
    }
    int mid = (low + high) / 2;
    if (qhigh <= mid && qlow >= low) {
      return query(mst, mid, low, qhigh, qlow, 2 * index + 1);
    }
    if (qlow > mid && qhigh <= high) {
      return query(mst, high, mid + 1, qhigh, qlow, 2 * index + 2);
    }
    return Math.min(
        query(mst, mid, low, qhigh, qlow, 2 * index + 1),
        query(mst, high, mid + 1, qhigh, qlow, 2 * index + 2));
  }

  public static void main(String[] args) {

    int[] arr = {1, 5, 2, 4, 3};
    int len = arr.length;
    int[] mst = new int[4 * len];
    buildTree(mst, len - 1, 0, 0, arr);
    System.out.println(query(mst, len - 1, 0, 4, 0, 0));
    System.out.println(query(mst, len - 1, 0, 3, 0, 0));
    System.out.println(query(mst, len - 1, 0, 4, 2, 0));
    update(mst, len - 1, 0, 0, 6, 2);
    System.out.println(query(mst, len - 1, 0, 4, 0, 0));
  }
}
