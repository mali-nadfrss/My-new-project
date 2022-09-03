class Solution {

    public int minimumDeletions(int[] nums) {
        if (nums.length == 1) return 1;
        int min = nums[0];
        int max = nums[0];
        int minI = 0;
        int maxI = 0;
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minI = i;
            } else if (nums[i] > max) {
                max = nums[i];
                maxI = i;
            }
        }

        int i = minI;
        int j = maxI;

        if (i == j) {
            ans = Math.min(ans, Math.min(i + 1, len - i));
        } else {
            int ans1 = Math.max(i + 1, j + 1);
            int ans2 = i + 1 + len - j;
            int ans3 = len - i + j + 1;
            int ans4 = Math.max(len - i, len - j);
            ans = Math.min(ans, ans1);
            ans = Math.min(ans, ans2);
            ans = Math.min(ans, ans3);
            ans = Math.min(ans, ans4);
        }

        return ans;
    }
}
