package com.mali.ds.bitManipulation;

/*
* https://practice.geeksforgeeks.org/problems/power-of-2/0
* */
public class PowerOf2 {

    static int findPower(int i){

        if(i == 1){
            return 1;
        }
        if(i % 2 != 0){
            return 0;
        }
        while(i > 1){

            if(i % 2 != 0 ){
                return 0;
            }
            i = i/2;
        }
        return 1;
    }
    public static void main(String[] args)  {
        System.out.println(findPower(32));
        System.out.println(findPower(15));
    }
}
