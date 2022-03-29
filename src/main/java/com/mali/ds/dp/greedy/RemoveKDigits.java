package com.mali.ds.dp.greedy;

import java.util.Stack;

/* https://leetcode.com/problems/remove-k-digits/
* medium
* */
public class RemoveKDigits {

    /* first intuition for such problems should be stack
    * todo */
    public String removeKdigits(String num, int k) {

        if (num.length() == k) return "0";
        Stack<Character>  stack = new Stack();
        int i = 0;
    while(k>0 && i < num.length()){
        if (stack.isEmpty() && num.charAt(i) != '0'){
            stack.push(num.charAt(i));
        } else {
            if (stack.peek() < num.charAt(i)){
                char c = stack.pop();
                stack.push(num.charAt(i));

            }
        }
    }
    return "";
    }

}
