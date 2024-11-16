package com.mali.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* https://leetcode.com/problems/make-k-subarray-sums-equal/solutions/3366373/k-cycles/?orderBy=most_votes */
public class MakeKSubarraySumsEqual {

  public static long makeSubKSumEqual(int[] arr, int k) {
    int len = arr.length;
    int grpLen = len/k;


    int ans = 0;

    for(int i = 0 ; i+k < len ; i++){
      ArrayList<Integer> list = new ArrayList<>();
      for(int j = i ; j < len ;j +=k){
        list.add(arr[j]);
      }

      int listLen = list.size();
      int median = 0;
      if(listLen % 2 == 0){
        median = (list.get(listLen/2)+list.get(listLen/2-1))/2;
      } else{
        median = list.get(listLen/2);
      }

      for(int j = i, l= 0 ; j < len ;j +=k, l++){
        ans += Math.abs(median-arr[j]);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    //
    int[] arr = {2, 5, 5, 7};
    int k = 3;
    makeSubKSumEqual(arr, k);
  }
}
