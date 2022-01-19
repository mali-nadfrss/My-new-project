package com.mali.ds.dp;

/*
https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/roses-for-valentine-4a795f72/
easy
 */
public class RosesInAShop {
  static int countRoses(int[] roses) {
    return recursion(roses);
  }

  static int recursion(int[] roses){
    int[] dp = new int[roses.length];
    for (int i = roses.length-1; i >= 0 ; i--) {
      if (i == roses.length-1){
        dp[i] = 1;
      } else if (roses[i] < roses[i+1]){
        dp[i] = dp[i+1] +1;
      } else{

      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] change = {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(countRoses(change));
  }
}
