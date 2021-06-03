package com.mali;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test2 {

  /*
      * Provided 2 strings, identify whether the strings are anagrams.

  "aba", "aab" -> true

  "abc", "acb" -> true

  "aab", "ab" -> false

  "abc", "aba" -> false
   * */

  public boolean areAnagrams(String input1, String input2) {

    if (input1.length() != input2.length()) {
      return false;
    }
    Map<Character, Integer> characterIntegerMap1 = new HashMap<>();
    for (int i = 0; i < input1.length(); i++) {
      if (input1.charAt(i) != input2.charAt(i)) {
        if (characterIntegerMap1.containsKey(input2.charAt(i))) {
          characterIntegerMap1.put(
              input1.charAt(i), characterIntegerMap1.getOrDefault(input1.charAt(i), 0) - 1);
        }
      } else {
        characterIntegerMap1.put(
            input1.charAt(i), characterIntegerMap1.getOrDefault(input1.charAt(i), 0) + 1);
      }
    }

    return true;
  }

  /*
    * Map<Integer, String>
        A 0
      /    \
     B -1     C 1
      \   /    \
       D 0 E 02   F 2
        /         \
       G 3         H 3
                /
               I 4
  ABDGI
    * */

  class Node {
    String data;
    Node left, right;
  }

  /*class DistanceNode {
    String data;
    int distance;
    DistanceNode(String data, int distance){
      this.data = data;
      this.distance = distance;
    }
    Node left, right;
  }*/

  public String leftView(Node root) {
    Map<Integer, String> integerStringMap = new LinkedHashMap<>();
    inOrder(root, integerStringMap, 0);
    String ans = "";
    for (Map.Entry<Integer, String> entry : integerStringMap.entrySet()) {
      ans = ans + entry.getValue();
    }
    return ans;
  }

  void inOrder(Node root, Map<Integer, String> integerStringMap, int height) {
    if (root == null) {
      return;
    }
    if (!integerStringMap.containsKey(height)) {
      integerStringMap.put(height, root.data);
    }

    inOrder(root.left, integerStringMap, height + 1);
    inOrder(root.right, integerStringMap, height + 1);
  }

  public static void main(String[] args) {

    System.out.println();
  }
}
