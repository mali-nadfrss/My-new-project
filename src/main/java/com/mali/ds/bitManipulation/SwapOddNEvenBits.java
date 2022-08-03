package com.mali.ds.bitManipulation;

/* https://www.geeksforgeeks.org/swap-all-odd-and-even-bits/ */
public class SwapOddNEvenBits {

    public static int swapBits(int n) {

        // Your code
        return (n & 0xAAAAAAAA)>> 1 | ( n & 0x55555555)<< 1;

    }
    public static void main(String[] args) {
        System.out.println(swapBits(23));
    }
}
