class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int totalSum = 0;
        int minSum = 0;
        int minLen = len - k;
        int ans = 100000;
        for (int i = 0; i < len; i++) {
            totalSum += cardPoints[i];
            minSum += cardPoints[i];
            if (i >= minLen) {
                minSum -= cardPoints[i - minLen];
                ans = Math.min(ans, minSum);
            }else{
        ans = minSum;
      }
        }
        return totalSum - ans;
    }
}
