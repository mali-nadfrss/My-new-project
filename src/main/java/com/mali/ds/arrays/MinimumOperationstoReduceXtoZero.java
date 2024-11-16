package com.mali.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * medium */
public class MinimumOperationstoReduceXtoZero {

  public static int maxScore(int[] cardPoints, int k) {

    // find min sub array sum of len-k
    int len = cardPoints.length;
    int totalSum = 0;
    int minSum = 0;
    int minLen = len - k;
    int ans = 100000;
    for (int i = 0; i < len; i++) {
      totalSum += cardPoints[i];
      minSum += cardPoints[i];
      if (i >= minLen) {
        minSum -= cardPoints[i - minLen];
        ans = Math.min(ans, minSum);
      } else {
        ans = minSum;
      }
    }
    return totalSum - ans;
  }

  public static int minOperations(int[] nums, int x) {

    int len = nums.length;
    long sum = 0;
    long curSum = 0;
    for (int i  :nums ) {
        sum+=i;
    }
    if(sum < x) return -1;
    sum -=x;
    if(sum == 0) return len;
    int start = 0;
    int ans = 0;
    for (int i = 0; i <len; i++) {
      if(sum == curSum){
        ans = Math.max(ans, i-start);
      }
      curSum += nums[i];
      while(curSum > sum){
        curSum -= nums[start++];
      }
    }
    if(sum == curSum){
      ans = Math.max(ans, len-start);
    }

    if (ans > 0 ) return len-ans;
    return ans;

  }

  public static void main(String[] args) {
    int A[] = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
    System.out.println(minOperations(A, 134365));
  }
}
