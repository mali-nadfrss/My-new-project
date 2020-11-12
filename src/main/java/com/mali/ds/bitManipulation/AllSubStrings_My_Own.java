package com.mali.ds.bitManipulation;

public class AllSubStrings_My_Own {

    static void subString(String s){
        int l = s.length();
        int n = (int) Math.pow(2,l);
        String[] ans = new String[n];
        boolean flag;
        for (int i = 0 ; i < l ; i++){

            for (int j = 0; j < n; j++) {

            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        String s = "abc";
        subString(s);
    }
}
