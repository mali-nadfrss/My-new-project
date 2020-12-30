package com.mali.ds.searchNsort;

public class SquareRoot {
    static long floorSqrt(long x) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        long low = 0;
        long high = x;
        long mid;
        while (low <= high) {
            mid = (low+high)/2;
            if( mid*mid == x){
                return mid;
            }
            if( mid*mid > x){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return (long) Math.floor(high);
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(99));
    }
}
