package com.mali.ds.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* https://aaronice.gitbook.io/lintcode/data_structure/design-search-autocomplete-system */
public class DesignSearchAutocompleteSystem {

  class Pair {
    String word;
    Integer count;

    Pair(String word, int count) {
      this.word = word;
      this.count = count;
    }
  }

  class Trie {
    Trie[] trie = new Trie[27];
    int count;
  }

  Trie trie = new Trie();

  void insert(String s, int times) {
    Trie temp = trie;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        if (temp.trie[26] == null) {
          temp.trie[26] = new Trie();
        }
        temp = temp.trie[26];
      } else {
        if (temp.trie[s.charAt(i) - 'a'] == null) {
          temp.trie[s.charAt(i) - 'a'] = new Trie();
        }
        temp = temp.trie[s.charAt(i) - 'a'];
      }
    }
    temp.count += times;
  }

  List<Pair> search(String s) {
    Trie temp = trie;
    List<Pair> list = new ArrayList<>();
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        if (temp.trie[26] == null) {
          return list;
        }
        temp = temp.trie[26];
      } else {
        if (temp.trie[c - 'a'] == null) {
          return list;
        }
        temp = temp.trie[c - 'a'];
      }
    }
    lookup(s, list, trie);
    return list;
  }

  List<Pair> lookup(String s, List<Pair> list, Trie trie) {
    if (trie.count > 0) {
      list.add(new Pair(s, trie.count));
    }
    for (int i = 0; i < 27; i++) {
      if (trie.trie[i] != null) {
        if (i == 26) {
          lookup(s + ' ', list, trie.trie[26]);
        }
        char j = (char) ('a' + i);
        lookup(s + j, list, trie.trie[i]);
      }
    }
    return list;
  }

  public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
    for (int i = 0; i < sentences.length; i++) {
      insert(sentences[i], times[i]);
    }
  }

  String cur = "";

  public List<String> input(char c) {
    List<String> res = new ArrayList<>();
    if (c == '#') {
      insert(cur, 1);
      cur = "";
    } else {
      cur += c;
      List<Pair> list = search(cur);
      Collections.sort(list, (a, b) -> Integer.compare(a.count, b.count));
      for (int i = 0; i < Math.min(3, list.size()); i++) {
        res.add(list.get(i).word);
      }
    }
    return res;
  }

  public static void main(String[] args) {

    String[] s = {"i love you", "island", "ironman", "i love leetcode"};
    int[] t = {5, 3, 2, 2};
    DesignSearchAutocompleteSystem d = new DesignSearchAutocompleteSystem(s, t);

    List<String> ans = d.input('i');
    ans = d.input('i');
    ans = d.input('i');
  }
}
