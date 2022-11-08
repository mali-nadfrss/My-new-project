class Solution {
    public String makeGood(String s) {
        
        boolean k = true;
        
        while(k){
        k  = false;
        for(int i = 0 ; i < s.length()-1 ; i++){
            int a = s.charAt(i);
            int b = s.charAt(i+1);
            
            if(Math.abs(a-b) == 32){
                s =  s.substring(0,i)+s.substring(i+2, s.length());
                k = true;
            }
            
        }
             
        }
        return s;
    }
}