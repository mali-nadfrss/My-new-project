package com.mali.ds.bitManipulation;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/utf-8-validation/ */
public class UTF8Validation {
  public static boolean validUtf8(int[] data) {
    if (data.length == 0) {
      return true;
    }
    Queue q= new LinkedList();
    int c = 0;

    for (int i : data) {
      if (c == 0) {
        if (i >> 5 == 110) c = 1;
        if (i >> 4 == 1110) c = 2;
        if (i >> 3 == 11110) c = 3;
        if (i >> 5 == 110) c = 1;
        else if (i >> 7 != 0) return false;
      } else {
        if (i >> 6 != 0b10) return false;
        c--;
      }
    }
    return c == 0;
  }

  public static void main(String[] args) {
    System.out.println(validUtf8(new int[] {15, 14}));
  }
}
