package com.mali.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/palindrome-partitioning/
medium
 */
public class PalindromePartitioning {
  public static List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    backTracking(ans, new ArrayList<>(), s, 0);
    return ans;
  }

  static void backTracking(List<List<String>> ans, List<String> tempList, String s, int start) {
    if (start == s.length()) {
      System.out.println("temp: " + tempList);
      ans.add(new ArrayList<>(tempList));
    }
    for (int i = start; i < s.length(); i++) {
      String temp = s.substring(start, i + 1);
      System.out.println("add: " + temp);
      if (isPalindrome(temp)) {
        tempList.add(temp);
        backTracking(ans, tempList, s, i + 1);
        if (!tempList.isEmpty()) {
          System.out.println("remove: " + tempList.get(tempList.size() - 1));
          tempList.remove(tempList.size() - 1);
        }
      }
    }
  }

  static boolean isPalindrome(String s) {
    int l = s.length();
    for (int i = 0; i < (l + 1) / 2; i++) {
      if (s.charAt(i) != s.charAt(l - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(partition("abab"));
  }
}
