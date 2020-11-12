package com.mali.general;

public class Sum {
    static int func(int n){
        if (n == 0 || n ==1 || n == 2){
            return 0;
        }
        if (n == 3){
            return 1;
        }
        else{
            return func(n-1)+func(n-2)+func(n-3);
        }
    }
    static void print(int n){
        for (int i = 1; i < n; i++) {
            System.out.println(func(i)+" ");
        }
    }

    public static void main(String[] args) {
        print(6);

    }
}
