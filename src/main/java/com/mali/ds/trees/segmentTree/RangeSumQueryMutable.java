package com.mali.ds.trees.segmentTree;

public class RangeSumQueryMutable {

  int[] search;
  int[] nums;

  public RangeSumQueryMutable(int[] nums) {
    search = new int[4 * nums.length + 1];
    this.nums = nums;
    insert(0, 0, nums.length - 1);
  }

  int insert(int pos, int start, int end) {

    if (start == end) {
      search[pos] = nums[start];
      return search[pos];
    }
    int mid = start + (end - start) / 2;

    search[pos] = insert(2 * pos + 1, start, mid) + insert(2 * pos + 2, mid + 1, end);
    return search[pos];
  }

  public void update(int index, int val) {
    int diff = val - nums[index];
    nums[index] = val;
    update(0, nums.length - 1, index, 0, diff);
  }

  void update(int start, int end, int index, int pos, int diff) {
    if (start > index || end < index) return;
    search[pos] = search[pos] + diff;
    int mid = start + (end - start) / 2;
    if (start != end) {
      update(start, mid, index, 2 * pos + 1, diff);
      update(mid + 1, end, index, 2 * pos + 2, diff);
    }
  }

  public int query(int left, int right, int ss, int se, int pos) {

    if (ss >= left && se <= right) {
      return search[pos];
    }
    if (ss > right || se < left) return 0;
    int mid = ss + (se - ss) / 2;

    return query(left, right, ss, mid, 2 * pos + 1) + query(left, right, mid + 1, se, 2 * pos + 2);
  }

  public int sumRange(int left, int right) {

    if (left < 0 || right > nums.length - 1 || left > right) return -1;
    return query(left, right, 0, nums.length - 1, 0);
  }

  public static void main(String[] args) {

    /*
        * ["NumArray","sumRange","update","sumRange","sumRange","update","update","sumRange","sumRange","update","update"]
    [[[-28,-39,53,65,11,-56,-65,-39,-43,97]],[5,6],[9,27],[2,3],[6,7],[1,-82],[3,-72],[3,7],[1,8],[5,13],[4,-67]]
        * */
    RangeSumQueryMutable r =
        new RangeSumQueryMutable(new int[] {-28, -39, 53, 65, 11, -56, -65, -39, -43, 97});
    System.out.println(r.sumRange(5, 6));
    r.update(9, 27);
    System.out.println(r.sumRange(2, 3));
    System.out.println(r.sumRange(6, 7));
    r.update(1, -82);
    r.update(3, -72);
    System.out.println(r.sumRange(3, 7));
    System.out.println(r.sumRange(1, 8));
    System.out.println(r.sumRange(5, 13));
    r.update(5, 13);
    r.update(4, -67);
  }
}
