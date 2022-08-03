package com.mali.ds.bitManipulation;

/* https://leetcode.com/problems/decode-xored-permutation/
 * medium */
public class DecodeXORedPermutation {

  public static int[] decode(int[] encoded) {

    // [a^b, b^c, c^d, d^e]
    // step 2 : b^c^d^e (if we take even ones)
    // step 3 : we know we have 1 to n (a to e --> a^b^c^d^e)
    // a = step2 ^ step 3 --> (b^c^d^e)^(a^b^c^d^e) == a
    int ans = 0;
    for (int i = 0; i < encoded.length; i++) {
      ans ^= i + 1;
      if (i % 2 == 1) {
        ans ^= encoded[i];
      }
    }
    ans ^= encoded.length + 1;

    int[] result = new int[encoded.length + 1];
    result[0] = ans;
    for (int i = 0; i < encoded.length; i++) {
      result[i + 1] = result[i] ^ encoded[i];
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(decode(new int[] {6, 5, 4, 6}));
  }
}
