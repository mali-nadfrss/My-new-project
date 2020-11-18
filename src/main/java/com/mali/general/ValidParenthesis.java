package com.mali.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {
    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack();
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == ')' && stack.isEmpty()){
                list.add(i);
            } else if (c == ')'){
                stack.pop();
            } else if (c == '('){
                stack.add('(');
            }
        }
        if (!stack.isEmpty()){
            for (int i = s.length()-1; i >= 0 ; i--) {
                if (s.charAt(i) == '(' && !stack.isEmpty()){
                    list.add(i);
                    stack.pop();
                }
            }
        }
        Collections.sort(list);
        String ans = "";
        for (int i =0, j = 0 ; i < s.length() ; i++){
            if (j < list.size() && list.get(j) == i){
                j++;
            }else{
                ans = ans+s.charAt(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "(a(b(c)d)";
        System.out.println(minRemoveToMakeValid(s));
    }
}
