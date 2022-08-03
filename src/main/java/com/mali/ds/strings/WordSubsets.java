package com.mali.ds.strings;

import java.util.*;

/* https://leetcode.com/problems/word-subsets/ */
public class WordSubsets {

  public static List<String> wordSubsets(String[] words1, String[] words2) {

    Map<Character, Integer> map = new HashMap<>();

    for (String word : words2) {
      Map<Character, Integer> map2 = new HashMap<>();
      for (char c : word.toCharArray()) {
        if (map2.get(c) == null) {
          map2.put(c, 1);
        } else {
          map2.put(c, map2.get(c) + 1);
        }

        if (map.get(c) == null || map2.get(c) > map.get(c)) {
          map.put(c, map2.get(c));
        }
      }
    }
    List<String> ans = new ArrayList<>();
    for (String word : words1) {

      Map<Character, Integer> map2 = new HashMap<>();
      for (char c : word.toCharArray()) {
        if (map2.get(c) == null) {
          map2.put(c, 1);
        } else {
          map2.put(c, map2.get(c) + 1);
        }
      }
      boolean test = true;
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        if ( map2.get(entry.getKey()) == null || map2.get(entry.getKey()) < entry.getValue()) {
          test = false;
          break;
        }
      }

      if (test) ans.add(word);
    }
    return ans;
  }

  public static void main(String args[]) {
    String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
    String[] words2 = {"e", "o"};
    System.out.println(wordSubsets(words1, words2));
  }
}
