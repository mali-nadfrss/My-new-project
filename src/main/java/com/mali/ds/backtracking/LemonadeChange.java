package com.mali.ds.backtracking;

/* https://leetcode.com/problems/lemonade-change/
easy */
public class LemonadeChange {

  public static boolean lemonadeChange(int[] bills) {
    int c5 = 0;
    int c10 = 0;
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] % 20 == 0) {
        if (c10 > 0 && c5 > 0) {
          c10--;
          c5--;
        } else if (c5 >= 3) {
          c5 = c5 - 3;
        } else {
          return false;
        }
      } else if (bills[i] % 10 == 0) {
        if (c5 > 0) {
          c5--;
          c10++;
        } else {
          return false;
        }
      } else {
        c5++;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {5, 5, 5, 5, 10, 5, 10, 10, 10, 20};
    System.out.println(lemonadeChange(nums));
  }
}
