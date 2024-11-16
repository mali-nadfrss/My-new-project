package com.mali.ds.design;

public class Base64 {

    public static String encode(String input){
        String inputBinary = "";
        for (char c : input.toCharArray()) {
            inputBinary += Integer.toBinaryString(c);
        }
return null;
    }

}
