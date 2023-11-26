package com.mali.ds.strings;

import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-373/problems/count-beautiful-substrings-i/
 * medium
 * */
public class CountBeautifulSubstringsI {

  public static int beautifulSubstrings(String s, int k) {
    int len = s.length();
    int[][] count = new int[len][2];
    int vc = 0;
    int cc = 0;
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    for (int i = 0; i < len; i++) {
      if (set.contains(s.charAt(i))) {
        vc++;
      } else {
        cc++;
      }
      count[i] = new int[] {vc, cc};
    }

    int ans = 0;
    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        int v = i > 0 ? count[j][0] - count[i - 1][0] : count[j][0];
        int c = i > 0 ? count[j][1] - count[i - 1][1] : count[j][1];
        if (v == c && (v * c) % k == 0) {
          ans++;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "pulorolqcvhafexui";
    int k = 9;
    System.out.println(beautifulSubstrings(s, k));
  }
}
