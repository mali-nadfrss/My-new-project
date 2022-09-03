class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums.length<3) return 0;
        int diff = nums[1]-nums[0];
        int start = 1;
        int ans = 0;
        int len = nums.length;
        for (int i = 2; i < len; i++) {
            if ( nums[i] - nums[i - 1] != diff) {
                diff = nums[i] - nums[i - 1];
                start = i;
            } else{
                ans += i - start;
            }
        }
        
        return ans;
    }
}
