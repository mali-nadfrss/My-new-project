class Solution {
    public int numberOfSubstrings(String s) {
        
        int a = -1;
        int b = -1;
        int c = -1;
        
        int ans = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            
            if(s.charAt(i) == 'a'){
                a = i;
            }
            if(s.charAt(i) == 'b'){
                b = i;
            }
            if(s.charAt(i) == 'c'){
                c = i;
            }
            
            int k =  Math.min(a, Math.min(b,c));
            if(k>= 0){
                ans += k+1;
            }
            
        }
        return ans;
    }
}