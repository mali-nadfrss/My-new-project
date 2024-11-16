package com.mali.ds.arrays;

import java.util.*;

/* https://leetcode.com/problems/apply-operations-to-maximize-score/description/ */
public class ApplyOperationstoMaximizeScore {

  public static int maximumScore(List<Integer> nums, int k) {

    int n = nums.size();
    int[] primeCount = new int[n];
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums.get(b) - nums.get(a));
    for (int i = 0; i < n; i++) {
      primeCount[i] = getPrimeCount(nums.get(i));
      pq.add(i);
    }
    Map<Integer, Integer> map = new HashMap<>();
    while (k > 0 && !pq.isEmpty()) {
      int cur = pq.poll();
      int count = k;
      int left = cur;

      for (int i = cur; i < n; i++) {
        if (primeCount[cur] >= primeCount[i]) {
          k--;
          left++;
        } else break;
      }
      for (int i = cur - 1; i >= 0; i--) {
        if (primeCount[cur] <= primeCount[i]) {
          k -= left - i;
          break;
        }
      }
      map.put(nums.get(cur), Math.min(count, count - k));
    }
    long ans = 1;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      for (int i = 0; i < entry.getValue(); i++) {
        ans = (ans * entry.getKey()) % MOD;
      }
    }

    return (int) ans;
  }

  public static final int MOD = 1000000007;

  static int getPrimeCount(int n) {
    if (n == 1) return 1;
    int count = 0;
    for (int prime : primes) {
      if (n % prime == 0) count++;
      if (prime > n) break;
    }
    return count;
  }

  static final int[] primes = {
    2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
    101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193,
    197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307,
    311, 313
  };

  public static void main(String[] args) {
    int[] nums = {1, 7, 11, 1, 5};
    int k = 14;
    List<Integer> list = new ArrayList<>();
    for (int i : nums) {
      list.add(i);
    }
    maximumScore(list, k);
  }
}
