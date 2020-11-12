package com.mali.ds.bitManipulation;

public class FlipA2B {

    static int flip(int A, int B){
        int C = A ^ B;
        int ans = 0;
        while(C > 0){
            if (C % 2 != 0){
                ans++;
            }
            C = C/2;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(flip(10, 20));
    }
}
