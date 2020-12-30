package com.mali.ds.arrays;

/* https://practice.geeksforgeeks.org/problems/rearrange-an-array-with-o1-extra-space3142/1/?track=dsa-workshop-1-arrays&batchId=308# */
public class ReArrange {

    static void arrange(long arr[], int n)
    {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i]+ (arr[(int) arr[i]]%n)*n;
        }


        for (int i = 0; i < n; i++) {
            arr[i] = arr[i]/n;
        }
    }
}
