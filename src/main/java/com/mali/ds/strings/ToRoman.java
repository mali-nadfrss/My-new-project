package com.mali.ds.strings;

public class ToRoman {

    static String convertToRoman(int n) {
        // Your code here
        String ans = "";
        final String[] ROMAN = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        final int[] numbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        for (int i = 12; i >= 0; i--) {
            while (n >= numbers[i]) {
                ans = ans + ROMAN[i];
                n = n - numbers[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(convertToRoman(14));
    }
}
