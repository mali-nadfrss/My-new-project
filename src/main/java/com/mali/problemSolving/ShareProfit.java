package com.mali.problemSolving;


//https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/?ref=lbp
public class ShareProfit {

    static int calProfit(int[] p){
        int ans = 0;
        int l = p.length;
        int[] a = new int[l];
        int max_price = p[l-1];
        for (int i = l-1; i >= 0 ; i--) {
            if (max_price <= p[i]){
                max_price = p[i];
            }
            ans = Math.max(ans,max_price-p[i]);
            a[i] = ans;
        }

        int min_price = p[0];

        for (int i = 0; i< l ; i++) {
            if (min_price > p[i]) {
                min_price = p[i];
            }
            ans = Math.max(ans, a[i] + p[i] - min_price);
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        int[] p = {2, 30, 15, 10, 8, 25, 80};
        System.out.println(calProfit(p));
    }
}
