package com.mali.ds.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* https://leetcode.com/contest/weekly-contest-307/problems/largest-palindromic-number/
medium */
public class LargestPalindromicNumber {

  public static String largestPalindromic(String num) {
    Map<Integer, Integer> map = new HashMap<>();

    // add all numbers by freq into a map
    for (char c : num.toCharArray()) {
      map.put(c - '0', map.getOrDefault(c - '0', 0) + 1);
    }

    // then add them into a pq to sort by num, freq
    PriorityQueue<int[]> pq =
        new PriorityQueue(
            (o1, o2) ->
                ((int[]) o2)[0] == ((int[]) o1)[0]
                    ? ((int[]) o2)[1] - ((int[]) o1)[1]
                    : ((int[]) o2)[0] - ((int[]) o1)[0]);

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pq.add(new int[] {entry.getKey(), entry.getValue()});
    }

    StringBuilder ans = new StringBuilder();
    int middle = 0;
    boolean needed = false;

    while (!pq.isEmpty()) {

      int[] entry = pq.poll();
      String temp = "";

      // add half of occrences to ans
      int count = entry[1] / 2;
      while (count > 0) {
        temp = temp + entry[0];
        count--;
      }
      ans.append(temp);

      // in case the freq is odd , we may need to add to middle.
      // only max of all odd occurrences qualify for middle number
      if (entry[1] % 2 == 1) {
        middle = Math.max(entry[0], middle);
        needed = true;
      }
    }

    String k = ans.toString();
    if (needed) {
      // if there is a single occurnec ad it to middle
      k = k + middle + ans.reverse();
    } else {
      // revrse the ans and it to and again// so that rest half will be added in reverse order
      k = k + ans.reverse();
    }

    // trailing zeroes
    int c = -1;
    for (int i = 0; i < k.length() / 2; i++) {
      if (k.charAt(i) == '0') {
        c++;
      } else break;
    }

    // remove all trailing zeroes from start and end
    if (c > -1 && c < k.length()) {
      k = k.substring(c + 1, k.length() - (c + 1));
    }
    // in case nothing got added as part of removing trailing zeroes return 0
    if (k.equals("")) return "0";
    return k;
  }

  public static void main(String[] args) {

    System.out.print(largestPalindromic("00011"));
  }
}
