package com.mali.ds.linkedList;

/* https://leetcode.com/problems/find-the-duplicate-number/
 * Medium */
public class FindtheDuplicateNumber {

  /* similar to https://leetcode.com/problems/linked-list-cycle-ii/submissions/ */
  public static int findDuplicate(int[] nums) {

    int slow = 0;
    int fast = 0;

    // this is similar to finding a cycle in linkedlist
    // but here we need to find exactly where the loop occurred
    for (int i = 0; i < nums.length; i++) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) break;
    }

    slow = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }

  public static int findDuplicateUsingBitManipulation(int[] nums) {
    int ans = 0;
    int n = nums.length;
    int bit_max = 31;
    while ((n >> bit_max) == 0) {
      bit_max -= 1;
    }
    for (int i = 0; i <= bit_max; i++) {
      int x = 0;
      int y = 0;
      for (int j = 0; j < n; j++) {
        if ((nums[j] & (1 << i)) != 0) {
          x += 1;
        }
        if (j >= 1 && (j & (1 << i)) != 0) {
          y += 1;
        }
      }
      if (x > y) {
        ans = ans | (1 << i);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 4, 2, 2};
    System.out.println(findDuplicate(arr));
    System.out.println(findDuplicateUsingBitManipulation(arr));
    double d= 5/2;
    System.out.println(Math.ceil(d));
  }
}
