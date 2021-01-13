package com.mali.ds.bitManipulation;

public class IsSparse {
    // Function to check if the given number is sparse or not
    public static boolean isSparse(int n) {
        // Your code here
        if (n == 0 || n == 1 || n == -1) {
            return true;
        }
        boolean flag = false;
        while (n >= 1) {
            if (n % 2 == 1) {
                if (flag)
                    return false;
                flag = true;
            }else {
                flag = false;
            }
            n = n / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSparse(41));
    }

}
