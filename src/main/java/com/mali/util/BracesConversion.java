package com.mali.util;

public class BracesConversion {

  public static String squareToFlower(String input) {
    StringBuilder ans = new StringBuilder();
    for (char c : input.toCharArray()) {
      if (c == '[') {
        ans.append('{');
      } else if (c == ']') {
        ans.append('}');
      } else {
        ans.append(c);
      }
    }
    return ans.toString();
  }

  public static void main(String[] args) {
    String input = "[[3,0],[2,1],[2,3]]";
    System.out.println(squareToFlower(input));
  }
}
