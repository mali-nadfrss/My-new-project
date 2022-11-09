class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int start = -1;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                list.add(i);
            }
            if (list.size() > k) {
                start = list.removeFirst();
            }
            if (list.size() == k) {
                ans += list.getFirst() - start;
            }
        }

        return ans;
    }
}
