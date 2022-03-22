package com.mali.ds.dp.stringsDp;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/edit-distance/
 * Hard
 * */
public class EditDistance {

  public static int minDistance(String word1, String word2) {
    return recursion(word1, word2, new HashMap<>());
  }

  static int recursion(String word1, String word2, Map<String, Integer> dp) {
    if (word1 == word2) {
      return 0;
    }
    if (word1 == "" || word2 == "") {
      // if any word is empty we need the other word length
      return word1 == "" ? word2.length() : word1.length();
    }
    //dp needs word1 and word2 because word1 might get duplicated
    if (dp.get(word1+word2) != null) {
      return dp.get(word1+word2);
    }
    if (word1.charAt(0) == word2.charAt(0)) {
      // if both chars are equal just check for next characters
      return recursion(word1.substring(1), word2.substring(1), dp);
    } else {
      // else condition, we have 3 options
      // delete the char in word1 as in below
      int ans1 = 1 + recursion(word1.substring(1), word2, dp);

      // replace the first character in word1 with that of word2 as in below
      int ans2 = 1 + recursion(word2.charAt(0) + word1.substring(1), word2, dp);

      // insert a new character from word2 into word1
      int ans3 = 1 + recursion(word2.charAt(0) + word1, word2, dp);

      // return the minimum of all 3
      dp.put(word1+word2, Math.min(Math.min(ans1, ans2), ans3));
    }
    return dp.get(word1+word2);
  }

  public static void main(String[] args) {
    System.out.println(minDistance("", "a"));
  }
}
