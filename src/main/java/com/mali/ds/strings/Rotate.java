package com.mali.ds.strings;

public class Rotate {

  /*  Function to check if two strings are rotations of each other
   *   s1, s2: are the input strings
   */
  public static boolean areRotations(String s1, String s2) {
    // Your code here
    return s1.length() == s2.length() && (s1 + s1).contains(s2);
  }

  public static void main(String[] args) {
    System.out.println(
        areRotations("dylsebxjwlmpamjneoehhlgayxtgs", "lsebxjwlmpamjneoehhlgayxfgsdy"));
  }
}
