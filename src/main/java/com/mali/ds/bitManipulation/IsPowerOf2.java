package com.mali.ds.bitManipulation;

public class IsPowerOf2 {

    static boolean isPowerOf2(int num){
        num = num & (num-1);
        return num == 0;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOf2(5));
        System.out.println(isPowerOf2(8));
    }
}
