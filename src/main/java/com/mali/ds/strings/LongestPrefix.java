package com.mali.ds.strings;

/*
https://leetcode.com/problems/longest-happy-prefix/
Hard
 */
public class LongestPrefix {
  public static String longestPrefix(String s) {
    String ans = "";
    StringBuilder pre = new StringBuilder();
    StringBuilder suf = new StringBuilder();
    int l = s.length();
    for (int i = 0; i < l - 1; i++) {
      pre.append(s.charAt(i));
      suf.insert(0, s.charAt(l - i - 1));
      if (suf.toString().equals(pre.toString())) {
        ans = pre.toString();
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(longestPrefix("g"));
  }
}
