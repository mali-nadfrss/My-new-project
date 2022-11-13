class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;

    int start = 0;
    int prev = -1;
    for (int i = 0; i < nums.length; i++) {

      if (nums[i] == k) ans++;
      if (k % nums[i] == 0) {
        if (prev != -1 &&lcm(nums[i], prev) == k) {
          ans += i - start;
        }
        prev = nums[i];
      } else {
        start = i + 1;
      }
    }
    return ans;
        
    }
    
    
    int gcd(int a, int b){
        
        if(a == 0) return b;
        return gcd(b%a,a);
        
    }
    
    int lcm(int a, int b){
         return (a / gcd(a, b)) * b;
        
    }
}