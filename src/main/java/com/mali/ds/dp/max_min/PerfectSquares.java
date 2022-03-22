package com.mali.ds.dp.max_min;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/perfect-squares/
medium
 */
public class PerfectSquares {
  public static int numSquares(int n) {
    return myOwnBackTracking(n, new HashMap<>());
  }

  public static int myOwnBackTracking(int n, Map<Integer, Integer> map) {
    if (n <= 0) {
      return 0;
    }
    if (map.containsKey(n)) {
      return map.get(n);
    }
    if (isPefectSquare(n)) {
      map.put(n, 1);
      return 1;
    }
    int ans = Integer.MAX_VALUE;
    for (int i = n; i > 0; i--) {
      if (isPefectSquare(i)) {
        int tempAns = myOwnBackTracking(n - i, map) + myOwnBackTracking(i, map);
        if (tempAns < ans) {
          ans = tempAns;
        }
        break;
      }
    }
    map.put(n, ans);
    return map.get(n);
  }

  public static boolean isPefectSquare(int n) {
    int k = (int) Math.sqrt(n);
    return k * k == n;
  }

  public static void main(String[] args) {
    System.out.println(numSquares(12));
  }
}
