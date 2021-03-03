package com.mali.ds.bitManipulation;

public class TwoNonDuplicateNumber {

    public static int[] findNonDuplicate(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        int k = leftMostSetBit(ans);
        int[] result = new int[]{0, 0};

        for (int i = 0; i < arr.length; i++) {
            if (hasKBitSet(arr[i], k)) {
                result[0] = result[0] ^ arr[i];
            }
        }
        result[1] = result[0] ^ ans;
        return result;
    }

    public static boolean hasKBitSet(int n, int k) {
        k = 1 << k;
        return (n & k) != 0;
    }

    public static int leftMostSetBit(int n) {
        int k = 1;
        int ans = 0;
        while (k <= n) {
            if ((n & k) == 1) {
                return ans;
            }
            ans++;
            k = k << 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
        System.out.println(findNonDuplicate(arr));
    }

}
