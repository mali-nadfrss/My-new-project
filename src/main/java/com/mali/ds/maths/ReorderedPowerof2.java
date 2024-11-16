package com.mali.ds.maths;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/problems/reordered-power-of-2/ */
public class ReorderedPowerof2 {

  public static boolean reorderedPowerOf2(int n) {
    if (n == 1) return true;
    Set<String> set = new HashSet<>();
    long temp = 1;
    for (int i = 0; i < 32; i++) {
      temp = temp << 1;
      String k = Long.toString(temp);
      char[] ar = k.toCharArray();
      Arrays.sort(ar);
      set.add(Arrays.toString(ar));
    }
    String k = Integer.toString(n);
    char[] ar = k.toCharArray();
    Arrays.sort(ar);
    return set.contains(Arrays.toString(ar));
  }

  public static void main(String[] args) {
    System.out.println(reorderedPowerOf2(10));
  }
}
