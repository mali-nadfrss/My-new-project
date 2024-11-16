package com.mali.ds.arrays;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-331/problems/rearranging-fruits/ */
public class RearrangingFruits {

  public static long minCost(int[] basket1, int[] basket2) {

    Map<Integer, Integer> map1 = new HashMap<>();
    for (int i : basket1) {
      map1.put(i, map1.getOrDefault(i, 0) + 1);
    }

    Map<Integer, Integer> map2 = new HashMap<>();
    for (int i : basket2) {
      map2.put(i, map2.getOrDefault(i, 0) + 1);
    }

    Set<Integer> set1 = new TreeSet<>();
    Set<Integer> set2 = new TreeSet<>(Collections.reverseOrder());
    for (int i : basket1) {
      int j1 = map1.get(i) == null ? 0 : map1.get(i);
      int j2 = map2.get(i) == null ? 0 : map2.get(i);

      if ((j1 + j2) % 2 != 0) {
        return -1;
      }

      if (j2 < j1) {
        set1.add(i);
      }
    }

    for (int i : basket2) {

      int j1 = map1.get(i) == null ? 0 : map1.get(i);
      int j2 = map2.get(i) == null ? 0 : map2.get(i);

      if ((j1 + j2) % 2 != 0) {
        return -1;
      }

      if (j2 > j1) {
        set2.add(i);
      }
    }

    long ans = 0;
    Iterator<Integer> i1 = set1.iterator();
    Iterator<Integer> i2 = set2.iterator();
    while (i1.hasNext()) {
      int i = i1.next();
      int j = i2.next();
      int count1 = 0;
      int count2 = 0;

      if (i <= j) {
        if (map2.get(i) == null) {
          count1 = map1.get(i);
        } else {
          count1 = map1.get(i) - map2.get(i);
        }
        ans += (long) Math.max(count1 / 2, 1) * i;
      } else {
        if (map1.get(j) == null) {
          count2 = map2.get(j);
        } else {
          count2 = map2.get(j) - map1.get(j);
        }
        ans += (long) Math.max(count2 / 2, 1) * j;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] b1 = {84,80,43,8,80,88,43,14,100,88};
    int[] b2 = {32,32,42,68,68,100,42,84,14,8};
    // 43, 80,
    //  42, 68



    System.out.println(minCost(b1, b2));
  }
}
