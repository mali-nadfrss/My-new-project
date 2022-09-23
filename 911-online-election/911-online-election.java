class TopVotedCandidate {
    Map<Integer, Integer> votesMap = new HashMap<>();

    TreeMap<Integer, Integer> timesMap = new TreeMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        int max = 0;
        int cur = persons[0];
        for (int i = 0; i < persons.length; i++) {
            votesMap.put(persons[i], votesMap.getOrDefault(persons[i], 0) + 1);
            if (max <= votesMap.get(persons[i])) {
                timesMap.put(times[i], persons[i]);
                max = votesMap.get(persons[i]);
                cur = persons[i];
            } else {
                timesMap.put(times[i], cur);
            }
        }
    }

    public int q(int t) {
        int key = timesMap.floorKey(t);
        return timesMap.get(key);
    }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
