package com.mali.ds.strings;

import java.util.ArrayList;
import java.util.List;

public class patternMatching {

  static List<Integer> findPattern(String s, String s1) {
    List<Integer> ans = new ArrayList<>();
    int l = s1.length();
    for (int i = 0; i < l; i++) {
      if (s1.charAt(i) == s.charAt(0) && isMatching(s, s1, i + 1, l)) {
        ans.add(i);
      }
    }
    return ans;
  }

  static boolean isMatching(String s, String s1, int i, int l) {
    for (int j = 1; j < s.length() && i < l; j++, i++) {
      if (s.charAt(j) != s1.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    String s = "aba";
    String s1 = "acabacjgjhabchkjhkabc";
    System.out.println(findPattern(s, s1));
  }
}
