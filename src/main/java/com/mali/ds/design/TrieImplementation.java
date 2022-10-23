package com.mali.ds.design;

import java.util.HashMap;
import java.util.Map;

public class TrieImplementation {

  class TrieNode {

    Map<Character, TrieNode> map;
    boolean isEndOfWord ;

    TrieNode() {
      map = new HashMap<>();
    }
  }

  TrieNode root;

  public TrieImplementation() {
    root = new TrieNode();
  }

  public void insert(String word) {
    insertRecursion(word, root, 0);
  }

  void insertRecursion(String word, TrieNode root, int index) {

    if (index >= word.length()) {
      root.isEndOfWord = true;
      return;
    }
    TrieNode cur = root.map.get(word.charAt(index));
    if (cur == null) {
      cur = new TrieNode();
      root.map.put(word.charAt(index), cur);
    }
    insertRecursion(word, cur, index + 1);
  }

  public boolean search(String word) {
    return searchRecursion(word, 0, root, true);
  }

  boolean searchRecursion(String word, int index, TrieNode node, boolean exactMatch) {
    if (index >= word.length()) {
      if (exactMatch) return node.isEndOfWord;
      return true;
    }
    TrieNode cur = node.map.get(word.charAt(index));
    if (cur != null) {
      return searchRecursion(word, index + 1, cur, exactMatch);
    } else {
      return false;
    }
  }

  public boolean startsWith(String prefix) {
    return searchRecursion(prefix, 0, root, false);
  }

  public static void main(String[] args) {
    TrieImplementation trie = new TrieImplementation();
    trie.insert("apple");
    System.out.println(trie.search("apple")); // return True
    System.out.println(trie.search("app")); // return False
    System.out.println(trie.startsWith("app")); // return True
    trie.insert("app");
    System.out.println(trie.search("app")); // return True
  }
}
