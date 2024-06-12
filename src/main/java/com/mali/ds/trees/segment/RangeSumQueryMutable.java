package com.mali.ds.trees.segment;

/*https://leetcode.com/problems/range-sum-query-mutable/description/ */
public class RangeSumQueryMutable {

  int[] tree;
  int count;

  public RangeSumQueryMutable(int[] nums) {
    this.count = nums.length;
    this.tree = new int[(count+1) * 4];

    for (int i = 0; i < count; i++) {
      update(i, nums[i], 0, count, 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 5};
    RangeSumQueryMutable obj = new RangeSumQueryMutable(nums);
    System.out.println(obj.sumRange(0, 1));
    obj.update(0, 2);
    System.out.println(obj.sumRange(0, 2));
  }

  public int query(int right, int left, int start, int end, int node) {
    if(right < start || left > end) return 0;
    if (start == end || (left <= start && right >= end)) {
      return tree[node-1];
    }
    int mid = (start + end) / 2;
    return query(right, left, mid + 1, end, 2 * node + 1)
        + query(right, left, start, mid, 2 * node);
  }

  public void update(int index, int val) {
    update(index, val, 0, count, 1);
  }

  public void update(int index, int val, int start, int end, int node) {
    if (start == end) {
      tree[node-1] = val;
      return;
    }
    int mid = (start + end) / 2;
    if (mid >= index) {
      update(index, val, start, mid, 2 * node);
    } else {
      update(index, val, mid + 1, end, 2 * node + 1);
    }
    tree[node-1] = tree[2 * node-1] + tree[2 * node];
  }

  public int sumRange(int left, int right) {
    return query(right, left, 0, count, 1);
  }
}
