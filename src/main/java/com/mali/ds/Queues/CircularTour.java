package com.mali.ds.Queues;

/*
 * medium 4
 * https://practice.geeksforgeeks.org/problems/circular-tour/1
 * */
public class CircularTour {

    int tour(int petrol[], int distance[]) {
        // Your code here
        int start = 0;
        int end = 1;
        int ans = petrol[0] - distance[0];
        while (start != end || ans < 0) {
            while (start != end && ans < 0) {
                ans = ans - petrol[0] + distance[0];
                start = start++ % petrol.length;
            }

        }
        return start;
    }
}
