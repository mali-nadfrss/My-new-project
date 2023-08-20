package com.mali.ds.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/contest/biweekly-contest-105/problems/extra-characters-in-a-string/ */
public class ExtraCharactersinaString {

  public static int minExtraChar(String s, String[] dictionary) {

    Set<String> set = new HashSet<>(Arrays.asList(dictionary));
    int[] dp = new int[s.length()];
    Arrays.fill(dp, -1);
    return recursion(set, s, 0, dp);
  }

  static int recursion(Set<String> set, String s, int index, int[] dp) {

    if (index >= s.length()) {
      return 0;
    }
    if (dp[index] > 0) return dp[index];
    int cur = Integer.MAX_VALUE;
    for (int i = index; i < s.length(); i++) {
      String str = s.substring(index, i + 1);
      if (set.contains(str)) {
        cur = Math.min(recursion(set, s, i + 1, dp), cur);
      } else {
        cur = Math.min(cur, i - index + 1 + recursion(set, s, index + 1, dp));
      }
    }
    return dp[index] = cur;
  }

  static boolean matches(String s, String word, int index) {
    for (int i = 0; i < s.length() - index && i < word.length(); i++) {
      if (s.charAt(index + i) != word.charAt(i)) return false;
    }
    return true;
  }

  public static void main(String[] args) {

    /*String s = "leetscode";
    String[] dictionary = {"leet", "code", "leetcode"};*/
    /*String s = "sayhelloworld";
    String[] dictionary = {"hello", "world"};*/
    String s = "dwmodizxvvbosxxw";

    String[] dictionary = {
      "ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz",
      "ds", "kzbu"
    };

    /*String s = "ecolloycollotkvzqpdaumuqgs";
    String[] dictionary = {
      "flbri", "uaaz", "numy", "laper", "ioqyt", "tkvz", "ndjb", "gmg", "gdpbo", "x", "collo",
      "vuh", "qhozp", "iwk", "paqgn", "m", "mhx", "jgren", "qqshd", "qr", "qpdau", "oeeuq", "c",
      "qkot", "uxqvx", "lhgid", "vchsk", "drqx", "keaua", "yaru", "mla", "shz", "lby", "vdxlv",
      "xyai", "lxtgl", "inz", "brhi", "iukt", "f", "lbjou", "vb", "sz", "ilkra", "izwk", "muqgs",
      "gom", "je"
    };*/
    System.out.println(minExtraChar(s, dictionary));
  }
}
