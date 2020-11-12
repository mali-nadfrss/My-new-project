package com.mali.ds.bitManipulation;

public class PositionOfSetBit {
    /*
    * https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1#
    */
    public static void main(String[] args)  {
        int i = 32;
        if (i == 1 ){
            System.out.println(1);
        }
        if (i % 2 != 0 || i == 0 ){
            System.out.println(-1);
        }
        int ans = 0;
        while(i > 1){
            ans++;
            i = i/2;
        }
        System.out.println(ans+1);
    }
}
