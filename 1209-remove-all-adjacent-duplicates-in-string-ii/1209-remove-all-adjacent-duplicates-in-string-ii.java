class Solution {
    public String removeDuplicates(String s, int k) {
        
          Stack<int[]> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            
            int C = c-'a';
            if(!stack.isEmpty() && stack.peek()[0] == C){
                if(stack.peek()[1]== k-1)
                    stack.pop();
                else
                    stack.peek()[1] = stack.peek()[1]+1;
            } else{
                stack.push(new int[]{C,1});
            }
            
        }
        
        
        String sb = "";
        int a = 'a';
        while(!stack.isEmpty()){
            
            char c = (char)(stack.peek()[0]+a);
            int count = stack.pop()[1];
            while(count >0){
                
                sb = c+sb;
                count--;
            }
            
        }
        
        return sb;
        
        
    }
}