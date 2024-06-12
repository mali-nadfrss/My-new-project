package com.mali.ds.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindLongestSpecialSubstringThatOccursThriceII {

    public static int maximumLength(String s) {
        int start = -1 ;
        char prev = s.charAt(0);
        int len = s.length();
        Map<Character, TreeMap<Integer, Integer>> map = new HashMap<>();
        int ans = -1;
        for(int i = 1 ; i < len ; i++){
            char c = s.charAt(i);
            if (c != prev ){
                start = i;
                if(i < len -1){
                    prev = s.charAt(i+1);
                }
                if (i - start == 1){
                    if (map.get(c) == null){
                        map.put(c, new TreeMap<>());
                        map.get(c).put(1,1);
                    } else{
                        TreeMap<Integer, Integer> ip = map.get(c);
                        for (Map.Entry<Integer, Integer> entry : ip.entrySet()){
                            if (entry.getKey()==1){
                                ip.put(1, ip.get(1)+1);
                            }
                            break;
                        }
                    }
                }

                if (i - start == 2){
                    if (map.get(c) == null){
                        map.put(c, new TreeMap<>());
                        map.get(c).put(1,2);
                        map.get(c).put(2,1);
                    }
                    else{
                        TreeMap<Integer, Integer> ip = map.get(c);
                        for (Map.Entry<Integer, Integer> entry : ip.entrySet()){
                            if (entry.getKey()==1){
                                ip.put(1, ip.get(1)+2);
                            }
                            if (entry.getKey()==2){
                                ip.put(2, ip.get(2)+1);
                                break;
                            }
                        }
                    }
                }
                if(i - start == 3){

                }
            }
        }

        return ans == 0 ? -1 : ans;


    }

    public static void main(String[] args) {
        System.out.println(maximumLength("abcaba"));
    }
}
