package com.mali.ds.trees.segmentTree;

/* https://leetcode.com/contest/weekly-contest-342/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/ */
public class MinimumNumberofOperationstoMakeAllArrayElementsEqualto1 {

  // should use binary search over segment tree
  public static int minOperations(int[] nums) {
    int len = nums.length;
    int count = 0;
    for (int num : nums) {
      if (num == 1) count++;
    }
    if (count > 0) return len - count;

    int ans = Integer.MAX_VALUE;
    int[] mst = new int[4 * len];
    build(mst, 0, 0, len - 1, nums);
    int low = 0;
    int high = len - 1;
    int gcd = query(mst, low, high, 0, len - 1, 0);
    if (gcd == 1) ans = Math.min(ans, len - 1 + high - low);
    ans = Math.min(binarySearch(mst, 0, high, len), ans);
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  static int binarySearch(int[] mst, int low, int high, int len) {
    int ans = Integer.MAX_VALUE;
    int mid = (low + high) / 2;
    int gcd1 = query(mst, low, mid, 0, len - 1, 0);
    int gcd2 = query(mst, mid + 1, high, 0, len - 1, 0);
    if (gcd1 == 1) {
      ans = Math.min(ans, len - 1 + mid - low);
      ans = Math.min(binarySearch(mst, low, mid, len), ans);
    }
    if (gcd2 == 1) {
      ans = Math.min(ans, len - 1 + mid - low);
      ans = Math.min(binarySearch(mst, mid + 1, high, len), ans);
    }
    return ans;
  }

  static int query(int[] mst, int qlow, int qhigh, int low, int high, int index) {
    if (qlow <= low && qhigh >= high) {
      return mst[index];
    }
    if (qlow > high || low > qhigh) return Integer.MAX_VALUE;
    int mid = (high + low) / 2;
    if (qhigh <= mid) return query(mst, qlow, qhigh, low, mid, 2 * index + 1);

    if (qlow > mid) return query(mst, qlow, qhigh, mid + 1, high, 2 * index + 2);
    else
      return gcd(
          query(mst, qlow, qhigh, low, mid, 2 * index + 1),
          query(mst, qlow, qhigh, mid + 1, high, 2 * index + 2));
  }

  static void build(int[] mst, int index, int low, int high, int[] nums) {
    if (low == high) {
      mst[index] = nums[low];
      return;
    }
    int mid = (high + low) / 2;
    build(mst, 2 * index + 1, low, mid, nums);
    build(mst, 2 * index + 2, mid + 1, high, nums);
    mst[index] = gcd(mst[2 * index + 1], mst[2 * index + 2]);
  }

  static int gcd(int a, int b) {
    if (b == 0) return a;
    if (a == 0) return b;
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    int[] arr = {4, 2, 6, 3};
    minOperations(arr);
  }
}
