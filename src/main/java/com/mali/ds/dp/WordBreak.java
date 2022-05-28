package com.mali.ds.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* https://leetcode.com/problems/word-break/ */
public class WordBreak {

  public static boolean wordBreak(String s, String[] wordDict) {
    Map<Character, List<String>> map = new HashMap<>();

    for (String k : wordDict) {
      map.computeIfAbsent(k.charAt(0), v -> new ArrayList<>());
      map.get(k.charAt(0)).add(k);
    }
    return dp(s, map, new HashMap<>());
  }

  static boolean dp(String s, Map<Character, List<String>> map, Map<String, Boolean> dp) {
    if (s.equals("")) {
      return true;
    }
    if (dp.get(s) != null) {
      return dp.get(s);
    }
    for (Object s1 : map.get(s.charAt(0)) != null ? map.get(s.charAt(0)) : new ArrayList<>()) {
      if (s.length() >= ((String) s1).length()
          && s.startsWith((String) s1)
          && dp(s.substring(((String) s1).length()), map, dp)) {
        dp.put(s.substring(((String) s1).length()), true);
        return true;
      }
    }
    dp.put(s, false);
    return false;
  }

  public static void main(String[] args) {
    String[] words = {
      "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"
    };
    System.out.println(
        wordBreak(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            words));
  }
}
