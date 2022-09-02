class Solution {
    public int maximumSum(int[] arr) {
        
       int len = arr.length;
       int od= arr[0] ;
        int nd = arr[0];
        int ans = arr[0];
        for(int i = 1; i < len  ; i++){
            
            od = Math.max(nd, od+arr[i]);
            nd = Math.max(nd+arr[i], arr[i]);
            ans = Math.max(ans, Math.max(nd, od));
            
        }
        return ans;
    }
}