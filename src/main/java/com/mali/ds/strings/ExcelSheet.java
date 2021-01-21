package com.mali.ds.strings;

public class ExcelSheet {

    public static String excelColumn(int N) {

        //  Your code here
        String ans = "";
        while (N > 0) {
            int k = N % 26;
            // handle case when reminder is 0 .. it should be treated as 26
            if (k == 0) {
                k = 26;
                N = N - 26;
            }
            char c = (char) (k + 'A' - 1);
            ans = c + ans;
            N = N / 26;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(excelColumn(53));
    }
}
