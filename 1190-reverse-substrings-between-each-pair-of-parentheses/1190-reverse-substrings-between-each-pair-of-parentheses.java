class Solution {

    public String reverseParentheses(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[len];
        
        for(int i = 0 ; i < len ; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } 
            if(s.charAt(i) == ')'){
                pair[i] = stack.pop();
                pair[pair[i]] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0, d= 1 ; i < len ; i+=d){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                d = -d;
                i = pair[i];
            } else{
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
