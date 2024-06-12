package com.mali.ds.dp;

import java.util.TreeSet;

/*https://leetcode.com/contest/biweekly-contest-121/problems/minimum-number-of-operations-to-make-x-and-y-equal/ */
public class MinimumNumberofOperationstoMakeXandYEqual {

    public static int minimumOperationsToMakeEqual(int x, int y) {

        int a = Math.min(x%11 + Math.abs(y-(x-x%11)/11), 11-x%11 + Math.abs(y-(x+(11-x%11))/11));
        int b = Math.min(x%5 + Math.abs(y-(x-x%5)/5), 5-x%5 + Math.abs(y-(x+(5-x%5))/5));
        int c = Math.abs(y-x);

        if(a <= b && a <= c ){
            if(x%11 <= 11-(x%11)) {

                return x%11 + minimumOperationsToMakeEqual(x/11, y);
            }else{
                return 11-x%11 + minimumOperationsToMakeEqual((x+1)/11, y);
            }
        }

        if(b <= a && b <= c ){
            if(x%5 <= 5-(x%5)) {
                return x%5 + minimumOperationsToMakeEqual(x/5, y);
            }else{
                return 5-x%5 + minimumOperationsToMakeEqual((x+1)/5, y);
            }
        }

        return c;


    }
    public static void main(String[] args){
        System.out.println(minimumOperationsToMakeEqual(26, 1));
    }


}
