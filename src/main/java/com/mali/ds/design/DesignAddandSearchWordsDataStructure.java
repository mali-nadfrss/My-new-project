package com.mali.ds.design;

/* https://leetcode.com/problems/design-add-and-search-words-data-structure/ */
public class DesignAddandSearchWordsDataStructure {

  static class Trie {
    Trie[] children = new Trie[26];
    char c;

    Trie(char c) {
      this.c = c;
    }
  }

  static Trie[] trie = new Trie[26];

  public static void addWord(String word) {

    Trie[] cur = trie;

    for (char c : word.toCharArray()) {
      int index = c - 'a';
      if (cur[index] == null) {
        cur[index] = new Trie(c);
      }
      cur = cur[index].children;
    }
  }

  public static boolean search(String word) {
    return search(word, 0);
  }

  public static boolean search(String word, int ind) {
    Trie[] cur = trie;
    for (int i = ind; i < word.length(); i++) {
      if (word.charAt(i) == '.') return search(word, i + 1);
      int index = word.charAt(i) - 'a';
      if (cur[index] == null) return false;
      cur = cur[index].children;
    }
    return true;
  }

  public static void main(String[] args) {

    int start = 0;
    int end = 1;
    String s = "sdcsd";
    StringBuilder sb  = new StringBuilder();
    if(start > 0)
    sb.append(sb.substring(0, start));
    for(int i = start; i< end ; i++ ){
      sb.append(s.charAt(i)-1);
    }
    if(end < s.length()-1)
      sb.append(s.substring(end, s.length()));

    addWord("bad");
    addWord("dad");
    addWord("mad");

    System.out.println(search("pad"));
    System.out.println(search("bad"));
    System.out.println(search(".ad"));
    System.out.println(search("b.."));
  }
}
