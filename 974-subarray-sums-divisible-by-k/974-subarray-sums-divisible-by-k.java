class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        int sum = 0;
        map.put(0,1);
        for (int num : nums) {
            sum += num;
            int rem = sum % k;
            if(rem<0)
                rem=rem+k;
            if ( map.get(rem) != null) {
                ans += map.getOrDefault(rem, 1);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return ans;
    }
}
