class Solution {
    public int longestPalindrome(String[] words) {
        
        Map<String, Integer> map = new HashMap<>();
        
        Map<String, Integer> palins = new HashMap<>();
        int ans = 0;
        
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        int lp = 0;
        for(Map.Entry<String , Integer> e : map.entrySet()){
            
            String s = e.getKey();
            String r = reverse(s);
             if(isPalin(s)){
                 if(map.get(s) % 2  == 0)
                ans +=  s.length()*map.get(s); 
                 else {
                     ans +=  s.length()*(map.get(s)-1); 
                     lp = Math.max(lp, s.length());
                 }
               
             }
            else if(palins.get(r) == null && map.get(r) != null){
                palins.put(s, Math.min(map.get(s), map.get(r)));
            } 
                
    
            
        }
        
        
        
        for(Map.Entry<String , Integer> e : palins.entrySet()){
            
            ans += e.getKey().length()*e.getValue()*2;
            
        }
        
        return ans+lp;
        
        
    }
    
    String reverse(String a){
        StringBuilder sb = new StringBuilder();
        return sb.append(a).reverse().toString();
    }
    
    boolean isPalin(String s ){
        
        int len = s.length();
        
        for(int i = 0 ; i <= len/2 ; i++){
            if(s.charAt(i) != s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
    
    //["dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"]
    
}