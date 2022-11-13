class Solution {

    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        int start = 0;
        int prev = -1;
        
        for (int i = 0; i < nums.length; i++) {
        
            // case if num = k
            if (nums[i] == k) ans++;
            
            //check if num has num is a multiple of k
            if (k % nums[i] == 0) {
                //check if lcm of current and prev lcm value is k
                if (prev != -1 && lcm(nums[i], prev) == k) {
                    // we sub arrays so just count from start to current
                    ans += i - start;
                }
                prev = nums[i];
            } else {
                //if its not a multiple simply start from next
                start = i + 1;
            }
        }
        return ans;
    }

    int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
