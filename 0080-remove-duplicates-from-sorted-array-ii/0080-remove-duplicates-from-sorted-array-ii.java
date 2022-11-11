class Solution {
    public int removeDuplicates(int[] nums) {
        
        int count = 1;
        int start = 0;
        int low = nums[0];
        
        for(int i = 1; i < nums.length ; i++){
            
            if(low == nums[i] && count ==1){
                count +=1;
                start +=1;
                nums[start] = low;
            } else if(nums[i] > low ){
                low = nums[i];
                count = 1;
                start += 1;
                nums[start] = low;
            }
            
        }
        
        return start+1;
        
    }
}