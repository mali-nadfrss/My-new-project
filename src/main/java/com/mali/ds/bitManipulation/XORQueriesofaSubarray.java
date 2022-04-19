package com.mali.ds.bitManipulation;

/* https://leetcode.com/problems/xor-queries-of-a-subarray/
 * medium */
public class XORQueriesofaSubarray {
  public static int[] xorQueries(int[] arr, int[][] queries) {
    int[] ans = new int[queries.length];
    for (int i = 1; i < arr.length; i++) {
      arr[i] = arr[i - 1] ^ arr[i];
    }
    int i = 0;
    for (int[] q : queries) {
      if (q[0] == 0) ans[i++] = arr[q[1]];
      else {
        ans[i++] = arr[q[0] - 1] ^ arr[q[1]];
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    /* 16 == 10000 ==> set at 3 ==> 10100 ==> 20*/
    int[] arr = {1,3,4,8};
    int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
    System.out.println(xorQueries(arr, queries));
  }
}
