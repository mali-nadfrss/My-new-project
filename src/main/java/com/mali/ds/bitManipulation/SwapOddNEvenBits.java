package com.mali.ds.bitManipulation;

/* https://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits-1587115621/1/?track=dsa-workshop-1-bit-magic&batchId=308 */
public class SwapOddNEvenBits {

    public static int swapBits(int n) {

        // Your code
        return (n & 0xAAAAAAAA)>> 1 | ( n & 0x55555555)<< 1;

    }
    public static void main(String[] args) {
        System.out.println(swapBits(23));
    }
}
