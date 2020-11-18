package com.mali.ds.bitManipulation;

public class CopySetBitsInRange {

    static void setBits(int x, int y, int l , int r){

        /* ex: r = 7 , l = 2
        * r = 10000
        * Copy set bits in a range
            https://www.geeksforgeeks.org/copy-set-bits-in-a-range/
         *   */
        int maskLength = ((1<<(r-l))-1)<<l;
        int mask = y & maskLength;
        System.out.println(x | mask);
    }

    public static void main(String[] args)  {
       setBits(10, 13, 2, 3);
    }
}
