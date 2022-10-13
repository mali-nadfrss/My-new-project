class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        
    Arrays.sort(
        people,
        (o1, o2) -> {
          if (o1[0] == o2[0]) {
            return o1[1] - o2[1];
          }
          return o2[0] - o1[0];
        });
    List<int[]> ans = new ArrayList<>();
    for (int i = 0; i < people.length; i++) {
        ans.add(people[i][1], people[i]);
    }

    return ans.toArray(new int[people.length][]);
        
    }
}