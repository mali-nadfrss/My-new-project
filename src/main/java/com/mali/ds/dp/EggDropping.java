package com.mali.ds.dp;

/*
medium
https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1/?track=md-dp&batchId=144
 */
public class EggDropping {
  static int eggDrop(int eggs, int floors) {
    if (floors == 0 || floors == 1) {
      return floors;
    }
    if (eggs == 1) {
      return floors;
    }
    int ans = Integer.MAX_VALUE;

    for (int i = 1; i <= floors; i++) {
      //
      int k = Math.max(eggDrop(eggs - 1, i - 1), eggDrop(eggs, floors-i));
      ans = Math.min(k, ans);
    }
    return ans+1;
  }

  public static void main(String[] args) {

      System.out.println(eggDrop(3,2));

  }
}
