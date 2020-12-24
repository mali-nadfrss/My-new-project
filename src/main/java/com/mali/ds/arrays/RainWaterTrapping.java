package com.mali.ds.arrays;

/* https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1/?track=dsa-workshop-1-arrays&batchId=308 */
public class RainWaterTrapping {

    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) {

        // Your code here
        int l = arr.length;
        int lmax = arr[0];
        int ans = 0 ;
        for (int i = 1; i < l; i++) {
            if (arr[i] > lmax){
                lmax = arr[i];
            }
            ans = ans + (lmax - arr[i]);
        }
        int rmax = arr[l-1];
        for (int i = l-1; i > 0; i--) {
            if (arr[i] == lmax){
                break;
            }
            if (arr[i] > rmax){
                rmax = arr[i];
            }
            ans = ans - (lmax - rmax);
        }
        return ans;
    }
}
