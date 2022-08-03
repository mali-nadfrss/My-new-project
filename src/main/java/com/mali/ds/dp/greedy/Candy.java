package com.mali.ds.dp.greedy;

import java.util.Arrays;

/* https://leetcode.com/problems/candy/ */
public class Candy {

  public static int candy(int[] ratings) {
    int ans = 0;
    int[] result = new int[ratings.length];
    Arrays.fill(result, 1);

    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        result[i] = result[i - 1] + 1;
      }
    }
    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        result[i] = Math.max(result[i-1], result[i+1])+1;
      }
    }
    for (int i : result) {
      ans = ans + i;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(candy(new int[] {1, 3, 4, 5, 2})); //11
    System.out.println(candy(new int[] {1, 2, 87, 87, 87, 2, 1})); //13
    System.out.println(candy(new int[] {1,6,10,8,7,3,2})); //18
  }
}
