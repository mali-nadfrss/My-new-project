class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        return recursion(arr, 0, arr.length-1, new int[arr.length][arr.length]);
        
    }
    
    
    int recursion(int[] arr, int start, int end, int[][] dp){
        
        if(start >= end){
            return 0;
        }
        
        if(dp[start][end] > 0) return dp[start][end];
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = start; i < end; i++){
        int left = recursion(arr, start, i, dp); 
        int right = recursion(arr, i+1, end, dp);
        
        int maxLeft = 0 ;
        int maxRight = 0 ;
        
        for(int j = start ; j <= i; j++){
            maxLeft = Math.max(maxLeft, arr[j]);
        }
        
        
        for(int j = i+1 ; j <= end; j++){
            maxRight = Math.max(maxRight, arr[j]);
        }
        
        ans = Math.min(ans, left+right+maxLeft*maxRight);    
        }    
        dp[start][end] =ans;
        return ans;
    }
}