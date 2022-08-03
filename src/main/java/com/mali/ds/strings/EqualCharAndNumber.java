package com.mali.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class EqualCharAndNumber {

  static int sol(String s) {

    int[] arr = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
        arr[i] = 1;
      } else {
        arr[i] = -1;
      }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int ans = 0;
    map.put(0, -1);
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (map.get(sum) != null) {
        ans = Math.max(ans, i - map.get(sum));
      } else map.put(sum, i);
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(sol("abcde123lmnop123345"));
  }
}
