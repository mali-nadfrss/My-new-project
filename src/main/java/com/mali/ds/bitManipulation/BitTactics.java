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
        System.out.println(1 << 1);//
        System.out.println(2 << 1); // 2 is 10 .. shift it by 1 position ==> 100 ==> 4
        System.out.println(3 << 1);// 3 is 11.. shift its position by 1 ==> 110
        System.out.println("hi"+ ~3);// shift its position by 2 ==> 100
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
        // >>> shifts bits to right side and excessive bits are discarded
        // a+b = a|b + a&b;
        num = num ^ position; // XOR --> boths 1 or both 0s gives 0 .. anyone is 1 gives 1
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
