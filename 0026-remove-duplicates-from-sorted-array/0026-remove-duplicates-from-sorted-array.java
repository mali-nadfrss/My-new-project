class Solution {
    public int removeDuplicates(int[] nums) {
        
       int start = 0;
        int low = nums[0];
        for(int i = 1; i < nums.length ; i++){
            if(nums[i] > low){
                low = nums[i];
                start+=1;
                nums[start] = low;
            }
        }
        
        return start+1;
        
    }
}