package com.mali.ds.stack;

public class MinHeapThreads {

    static int minCost(int[] arr) {
        MinStack m = new MinStack();
        for (int i = 0; i < arr.length; i++) {
            m.push(arr[i]);
        }
        int cost = 0;
        while (!m.isEmpty()) {
            int temp = m.pop();
            if (!m.isEmpty()) {
                temp = temp + m.pop();
            } else {
                cost = cost + temp;
                break;
            }
            cost = cost + temp;
            m.push(temp);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        System.out.print(minCost(arr));
    }

}
