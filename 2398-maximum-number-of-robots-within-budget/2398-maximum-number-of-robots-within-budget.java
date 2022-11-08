class Solution {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0;
        int start = 0;
        long costSum = 0;

        int count = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < chargeTimes.length; i++) {
            costSum += runningCosts[i];
            map.put(chargeTimes[i], map.getOrDefault(chargeTimes[i], 0) + 1);
            count++;
            while (map.size() > 0 && map.floorEntry(Integer.MAX_VALUE).getKey() + count * costSum > budget) {
                if (map.get(chargeTimes[start]) > 1) {
                    map.put(chargeTimes[start], map.get(chargeTimes[start]) - 1);
                } else {
                    map.remove(chargeTimes[start]);
                }
                count--;
                costSum -= runningCosts[start];
                start++;
            }
            ans = Math.max(ans, count);
        }
        ans = Math.max(ans, count);

        return ans;
    }
}
