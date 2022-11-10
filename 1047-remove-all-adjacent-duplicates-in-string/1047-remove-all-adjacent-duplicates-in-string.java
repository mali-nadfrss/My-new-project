class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            } else{
                stack.push(c);
            }
            
        }
        
        
        String sb = "";
        while(!stack.isEmpty()){
            sb = stack.pop()+sb;
            
        }
        
        return sb;
        
    }
}