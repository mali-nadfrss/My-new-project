package com.mali.ds.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {



  static class TrieNode {
    Map<Character, TrieNode> map;

    TrieNode() {
      map = new HashMap();
    }
  }

  static TrieNode root;

  static void insert(TrieNode root, int index, String word) {

    int[] i = new int[]{1,2,3};
    Arrays.sort(i);
    if (index >= word.length()) {
      return;
    }
    TrieNode cur = root.map.get(word.charAt(index));
    if (cur == null) {
      cur = new TrieNode();
      root.map.put(word.charAt(index), cur);
    }

    insert(cur, index + 1, word);
  }

  static String traverse(TrieNode root) {

    if (root == null || root.map.size() != 1) {
      return "";
    }
    Character c = root.map.keySet().iterator().next();
    return c + traverse(root.map.get(c));
  }

  static String longestCommonPrefix(String[] strs) {

    root = new TrieNode();

    for (String word : strs) {
      insert(root, 0, word);
    }
    String k = traverse(root);
    return k;
  }

  public static void main(String[] args) {
    String[] strs = {"flower", "dog", "flight"};
    System.out.println(longestCommonPrefix(strs));
  }
}
