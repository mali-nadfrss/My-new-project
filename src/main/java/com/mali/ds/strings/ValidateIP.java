package com.mali.ds.strings;

public class ValidateIP {
    public static boolean isValid(String s) {
        // Write your code here
        String[] arr = s.split("\\.");
        if (arr.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            try {
                if (arr[i] == "0"){
                 continue;
                }
                int j = Integer.parseInt(arr[i]);
                if (j <= 255 && j > 0) {
                    continue;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("09.09.09.09"));
    }
}
