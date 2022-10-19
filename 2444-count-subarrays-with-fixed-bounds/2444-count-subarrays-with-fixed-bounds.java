class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        
       long ans = 0;
        int min = -1;
        int max = -1;
        int start = 0;
    
    for (int i = 0; i <nums.length; i++) {
     
        if(nums[i] < minK || nums[i] > maxK){
            
            start = i+1;
            min = i;
            max = i;
            
        }
        if(nums[i] == minK){
            min = i;
        }
        if(nums[i] == maxK){
            max = i;
        }
        
        ans = ans+(i-start+1)-(i-(Math.min(min, max)+1)+1);
    }
    return ans;
        
    }
}