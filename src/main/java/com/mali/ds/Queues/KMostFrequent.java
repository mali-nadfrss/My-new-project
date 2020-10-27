package com.mali.ds.Queues;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KMostFrequent {

    static void logic(int[] arr, int k) {

        Map<Integer, Integer> m = new HashMap();
        for (int i :
                arr) {
            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else {
                m.put(i, 1);
            }
        }

        List<List<Integer>> freq = new ArrayList<List<Integer>>();

        for (int i = 0 ; i < arr.length ; i++){
            freq.add(new ArrayList<Integer>());
        }

        for (Map.Entry e: m.entrySet()){
            freq.get((Integer) e.getValue()).add((Integer) e.getKey());
        }
        int count = 0;
        for (int i = freq.size()-1 ; i >= 0 ; i--){
            if (freq.get(i).size() > 0){
                for (int j:
                        freq.get(i)) {
                    System.out.println(j);
                    count = count+1;
                    if (count >=k){
                        return;
                    }
                }
            }

        }
    }


    public static void main(String args[]) {

        int[] arr = {1, 2, 3, 5, 4, 4, 5};
        logic(arr, 3);
    }
}
