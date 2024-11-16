package com.mali.ds.Queues;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/minimum-number-of-frogs-croaking/ */
public class MinimumNumberofFrogsCroaking {

  public static int minNumberOfFrogs(String croakOfFrogs) {
    Map<Character, Character> map = new HashMap<>();

    map.put('k', 'a');
    map.put('a', 'o');
    map.put('o', 'r');
    map.put('r', 'c');
    map.put('c', 'k');

    Map<Character, Integer> q = new HashMap<>();

    int ans = 0;
q.put('k', 1);
    for (char c : croakOfFrogs.toCharArray()) {

      if (q.getOrDefault(map.get(c), 0) <= 0 && c != 'c') {
        return -1;
      }
        q.put(map.get(c), q.get(map.get(c)) - 1);

      if (c != 'k') {
        q.put(c, q.getOrDefault(c, 0) + 1);
      }

      ans = Math.max(ans, q.getOrDefault(c, 0));
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(minNumberOfFrogs("crcoakroak"));
  }
}
