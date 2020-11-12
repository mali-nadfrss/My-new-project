package com.mali.ds.bitManipulation;

import com.mali.designPattern.proxy.InternetConnection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubStrings {

    static void subString(String s){
        int n = (int) Math.pow(2,s.length());
        List<String> list  = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int mask = 1<<j;
                if ((mask&i) != 0){
                    str.append(s.charAt(j));
                }
            }
            if (str.length() > 0){
                list.add(str.toString());
                System.out.println(str);
            }

        }
        System.out.println(list);
    }
    public static void main(String[] args) throws Exception {
        String s = "abcd";
        subString(s);
    }
}
