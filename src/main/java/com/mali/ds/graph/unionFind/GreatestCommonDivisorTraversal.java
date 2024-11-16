package com.mali.ds.graph.unionFind;

import java.util.*;

/* https://leetcode.com/contest/biweekly-contest-105/problems/greatest-common-divisor-traversal/ */
public class GreatestCommonDivisorTraversal {

  static TreeSet<Integer> primes = new TreeSet<>();

  static {
    primes.add(2);
    for (int i = 2; i < 100000; i++) {
      boolean flag = true;
      for (int j : primes) {
        if (i % j == 0) {
          flag = false;
          break;
        }
      }
      if (flag) primes.add(i);
    }
  }

  static void cal(int a, Set<Integer> set) {

    for (int i : primes) {
      if (a % i == 0) set.add(i);
      if (a < i) break;
    }
  }

  public static boolean canTraverseAllPairs(int[] nums) {

    int rank = nums[0];

    List<Integer> list = new ArrayList<>();
    for (int i : nums) {
        list.add(i);
    }
    int[] nums1 = new int[list.size()];
    for (int j = 0, listSize = list.size(); j < listSize; j++) {
      nums1[j] = list.get(j);
    }
    int len = nums.length;
    if (len == 1) return true;
    Set<Integer> set = new HashSet<>();
    cal(rank, set);

    for (int i = 1; i < len; i++) {
      Set<Integer> temp = new HashSet<>();
      cal(nums1[i], temp);
      gcd(set, temp);
    }

    for (int i = 0; i < len; i++) {
      Set<Integer> temp = new HashSet<>();
      cal(nums1[i], temp);
      if (!gcd(set, temp)) return false;
    }

    return true;
  }

  static boolean gcd(Set<Integer> a, Set<Integer> b) {
    for (int i : b) {
      if (a.contains(i)) {
        a.addAll(b);
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 6};
    System.out.println(canTraverseAllPairs(nums));
  }
}
