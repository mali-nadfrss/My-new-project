package com.mali.ds.Queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
 * https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620
 * EASY
 * */
public class BinaryNumbers {

    static ArrayList<String> generate(int N) {
        // Your code here
        Queue<String> q = new ArrayDeque();
        ArrayList<String> ans = new ArrayList();
        q.offer("1");
        while (N-- > 0) {
            String s = q.poll();
            ans.add(s);
            q.offer(s + "0");
            q.offer(s + "1");
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generate(10));
    }
}
