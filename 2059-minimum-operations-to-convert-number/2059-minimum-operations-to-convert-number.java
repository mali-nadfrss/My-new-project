class Solution {

    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        Set<Integer> set = new HashSet<>();

        int res = 0;
        int val = 0;
        while (!q.isEmpty()) {
            
            int len = q.size();
            
            for(int i = 0 ; i < len ; i++){
            val = q.poll();

            if (val == goal) return res;

            if (val < 0 || val > 1000) {
               continue;
            }
            if (!set.add(val)) {
                continue;
            }

            for (int num : nums) {
                q.add(val + num);
                q.add(val - num);
                q.add(val ^ num);
            }
            }
            res++;
        }
        if (val == goal) return res;

        return -1;
    }
}
