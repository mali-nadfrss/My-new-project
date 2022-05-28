package com.mali.ds.graph;

import java.util.Stack;

/* https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
medium  */
public class AlienDictionary {

  // topological sort
  char[] printOrder(String[] words) {
    int[][] graph = new int[26][26];
    for (String word : words) {
      int k = word.charAt(0) - 'a';
      for (int i = 0; i < word.length(); i++) {
        graph[k][word.charAt(i)] = i;
      }
    }
    Stack<Character> st = new Stack<>();
    boolean[] visited = new boolean[26];
    for (String word : words) {
     // if (visited[word.charAt(0)-'a'])
           // recursion();
    }

    return null;
  }

  void recursion(String word, char[][] graph, Stack<Character> st, boolean[] visited){
    if (visited[word.charAt(0)]){
      return;
    }
   // st.push(word.charAt())
  }

}
