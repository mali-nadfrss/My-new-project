package com.mali.ds.strings;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ExcelSheet {

    public static String excelColumn(int N) {

        //  Your code here
        String ans = "";
        while (N > 0) {
            int k = N % 26;
            N=N/26;
            // handle case when reminder is 0 .. it should be treated as 26
            if (k == 0) {
                k = 26;
                N--;
            }
            char c = (char) (k + 'A' - 1);
            ans = c + ans;

        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(excelColumn(52));
    }
}
