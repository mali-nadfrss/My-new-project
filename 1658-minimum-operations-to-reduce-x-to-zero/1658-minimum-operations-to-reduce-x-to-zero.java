class Solution {

    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int sum = 0;
        int curSum = 0;
        for (int i : nums) {
            sum += i;
        }
          if(sum < x) return -1;
        sum -= x;
        if(sum == 0) return len;
        int start = 0;
        int ans = -1;
        for (int i = 0; i < len; i++) {
            if (sum == curSum) {
                ans = Math.max(ans, i - start);
            }
            curSum += nums[i];
            while (curSum > sum) {
                curSum -= nums[start++];
            }
        }
        if(sum == curSum){
      ans = Math.max(ans, len-start);
    }

        if (ans > 0) return len - ans;
        return ans;
    }
}
