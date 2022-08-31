class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        long sum = 0;
        int len = nums.length;
        int[] ans = new int[len];
        if(k > len/2) {
            
            Arrays.fill(ans, -1);
            return ans;
            
        }
        for(int i = 0; i < 2*k ; i++){
            sum += nums[i];
        }
        
        for(int i = 0 ; i < len ; i++){
            
            if(i < k || len-i <= k){
                ans[i] = -1;
            } else{
                
                sum += nums[i+k];
                sum -= i-k-1 >= 0 ? nums[i-k-1] : 0;
                ans[i] = (int)(sum/(long)(2*k+1));
                
            }
            
            
        }
        
        return ans;
        
    }
}