package com.mali.ds.searchNsort;

public class FindMedian {

    public static int findMedian(int[] arr, int n, int[] brr, int m) throws Exception {
        //Your code here
        if (n > m) {
            return findMedian(brr, m, arr, n);
        }
        int med = 0;
        int k = 0;
        int start = 0;
        int end = n;
        while (start <= end) {
            med = (start + end) / 2;
            k = (m + n + 1) / 2 - med;
            int leftN = med == 0 ? Integer.MIN_VALUE : arr[med - 1];
            int rightN = med == n ? Integer.MAX_VALUE : arr[med];

            int leftM = k == 0 ? Integer.MIN_VALUE : brr[k - 1];
            int rightM = k == m ? Integer.MAX_VALUE : brr[med];

            if (leftN <= rightM && leftM <= rightN) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(leftM, leftN) + Math.max(rightM, rightN)) / 2;
                } else {
                    return Math.max(leftM, leftN);
                }
            } else if (leftN > rightM) {
                end = med - 1;
            } else {
                start = med + 1;
            }
        }

        throw new Exception("test");
    }


    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,4,5};
        int[] brr = {3,4,5,6,7,8};
        System.out.println(findMedian(arr, 5, brr, 6));
    }
}
