class Solution {

    int gcd(int a, int b)
{
    if (a == 0)
        return b;
    return gcd(b % a, a);
}
 
// method to return LCM of two numbers
 int LCM(int a, int b)
{
    return (a / gcd(a, b)) * b;
}

public int subarrayLCM(int[] nums, int k) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
        int currLCM = nums[i];
        if(currLCM == k) // if element is equal to k, increment answer
            ans++;
        for (int j = i + 1; j < nums.length; j++) {
            if(nums[j] > k) // if nums[j] > k lcm can never be equal to k for this subarray
                break;
            currLCM = LCM(nums[j], currLCM);
            if (currLCM == k)
                ans++;
        }
    }
    return ans;
}
}
