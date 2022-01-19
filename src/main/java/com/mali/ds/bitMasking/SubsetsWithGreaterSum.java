package com.mali.ds.bitMasking;

public class SubsetsWithGreaterSum {
  public static int count(int[] set, int val) {
    int count = 0;
    for (int i = 0; i < Math.pow(2, set.length); i++) {
      int sum = 0;
      for (int j = 0; j < set.length; j++) {
        if ((i & (1 << j)) > 0) {
          sum += set[j];
        }
      }
      if (sum >= val) count += 1;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(count(new int[]{1,2,3}, 3));
    //{3}{1,3}{2,3}{1,2}{1,2,3}
  }
}
