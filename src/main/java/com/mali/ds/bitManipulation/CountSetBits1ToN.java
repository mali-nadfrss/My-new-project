package com.mali.ds.bitManipulation;

public class    CountSetBits1ToN {

    /*
    * https://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/
    */
    static int solve(int n){
        int x = 0;
        int i = 1;
        if (n <= 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }
        while (i <= n){
            i = 1 << i;
            x++;
        }
        int y= (int) Math.pow(2,x-1);
        return y*x + (n-y*2+1)+solve(n-y*2);
    }
    public static void main(String[] args)  {
        System.out.println(solve(4));
    }
}
