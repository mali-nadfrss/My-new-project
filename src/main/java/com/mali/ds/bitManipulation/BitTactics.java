package com.mali.ds.bitManipulation;

public class BitTactics {

    public static int setBitAtPosition(int num, int position) {
        position = 1 << position;
        num = num | position;
        return num;
    }

    public static int unSetBitAtPosition(int num, int position) {
        position = 1 << position;
        position = ~position;
        num = num & position;
        return num;
    }

    public static int checkBitAtPosition(int num, int position) {
        position = 1 << position;
        num = num & position;
        return num;
    }

    public static int flipBits(int num) {
        int temp = num;
        int ans = 1;
        while (temp > 1) {
            ans = ans << 1;
            ans = ans + 1;
            temp = temp >> 1;
        }
        return ans - num;
    }

    public static int toggleBitAtPosition(int num, int position) {
        position = 1 << position;
        position = ~position;
        num = num ^ position;
        return num;
    }

    public static void swap(int[] arr) {
        arr[0] = arr[0] ^ arr[1];
        arr[1] = arr[0] ^ arr[1];
        arr[0] = arr[0] ^ arr[1];
    }

    public static void main(String[] args) {
        /* 16 == 10000 ==> set at 3 ==> 10100 ==> 20*/
        System.out.println(setBitAtPosition(16, 3));
        System.out.println(unSetBitAtPosition(15, 3));
        System.out.println(toggleBitAtPosition(16, 3));
        System.out.println(checkBitAtPosition(15, 3));
        System.out.println(checkBitAtPosition(16, 3));
        int[] arr = new int[]{78, 89};
        swap(arr);
        System.out.print(arr[0] + " " + arr[1]);
        System.out.println();
        System.out.println(flipBits(14));
    }
}
