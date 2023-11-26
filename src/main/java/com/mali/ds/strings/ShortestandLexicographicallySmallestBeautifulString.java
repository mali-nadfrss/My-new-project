package com.mali.ds.strings;

/* https://leetcode.com/contest/weekly-contest-367/problems/shortest-and-lexicographically-smallest-beautiful-string/ */
public class ShortestandLexicographicallySmallestBeautifulString {

  public static String shortestBeautifulSubstring(String s, int k) {


    k = k - 1;
    String ans = "";
    int n = s.length();
    int[] arr = new int[n];
    arr[0] = s.charAt(0) == '1' ? 1 : 0;
    if (k == 0 && n == 1 && arr[0] == 1)
      return s;
    int start = 0;
    int len = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      arr[i] = arr[i - 1];
      if (s.charAt(i) == '1') {
        arr[i] += 1;
        while (arr[i] - arr[start] > k || (arr[i] - arr[start] == k && s.charAt(start) == '0')) {
          start += 1;
        }
        String temp = s.substring(start, i + 1);
        if (arr[i] - arr[start] == k && i - start < len) {
          ans = temp;
          len = i - start;
        } else if (arr[i] - arr[start] == k && i - start == len) {
          ans = cmpr(ans, temp);
          len = i - start;
        }
      }
    }

    return ans;
  }

  static String cmpr(String s1, String s2) {
    int len = s1.length();
    for (int i = 0; i < len; i++) {
      if (s1.charAt(i) > s2.charAt(i)) return s2;
      if (s1.charAt(i) < s2.charAt(i)) return s1;
    }
    return s1;
  }

  public static void main(String[] args) {
    String s = "0101111000101011001";
    int k = 9; // -> 101111000101011

    // String s = "001110101101101111";
    // int k = 10;//"10101101101111"
    shortestBeautifulSubstring("1", 1);
  }
}
