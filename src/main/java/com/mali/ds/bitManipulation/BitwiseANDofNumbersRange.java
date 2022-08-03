package com.mali.ds.bitManipulation;

/* https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * medium */
public class BitwiseANDofNumbersRange {
  public static int rangeBitwiseAnd(int left, int right) {

    int c = 1;

    //for 6, 7 --> 110 && 111 right shift would return 11 , 11 which are equal so return 3*2

    while (left != right) {
      c=c<<1;
      left = left >> 1;
      right = right >> 1;
    }

    return left * c;
  }

  public static void main(String[] args) {
    System.out.println(rangeBitwiseAnd(5, 7));
  }
}
