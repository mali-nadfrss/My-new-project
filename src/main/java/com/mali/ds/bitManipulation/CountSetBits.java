package com.mali.ds.bitManipulation;

/*
 * https://practice.geeksforgeeks.org/problems/set-bits0143/1
 * */
public class CountSetBits {
    public static void main(String[] args) {
        int i = 7, n = 7;
        int ans = 0;
        while (i > 0) {
            i = i & (i - 1);
            ans++;
        }
        System.out.println(ans);
        int ans1 = 0;
        while (n > 0) {
            if(n%2 != 0 ){
                ans1++;
            }
            n = n / 2;
        }
        System.out.println(ans1);
    }

}
