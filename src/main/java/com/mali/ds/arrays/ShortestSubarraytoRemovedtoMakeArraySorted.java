package com.mali.ds.arrays;

/* https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/ */
public class ShortestSubarraytoRemovedtoMakeArraySorted {

  public static int findLengthOfShortestSubarray(int[] arr) {

    int len = arr.length;
    int r = len - 1;
    while (r > 0 && arr[r] > arr[r - 1]) {
      --r;
    }
    int ans = r;
    for (int i = 0; i < r && (i == 0 || arr[i] >= arr[i - 1]); ++i) {
      while (r < len && arr[r] < arr[i]) {
        ++r;
      }
      ans = Math.min(ans, r - i - 1);
    }
    return ans;
  }

    public String removeStars(String s) {

        int c = 0;
        String ans = "";

        for(int i = s.length()-1 ; i >= 0 ; i--){

            if(s.charAt(i) == '*' ){
                c++;
            } else {

                if(c == 0)
                    ans = ans +s.charAt(i);
                else{
                    c--;
                }
            }

        }
        return ans;

    }

  public static void main(String[] args) {

    System.out.println(findLengthOfShortestSubarray(new int[] {1, 2, 3, 10, 4, 2, 3, 5}));
    System.out.println(findLengthOfShortestSubarray(new int[] {5, 4, 3, 2, 1}));
    System.out.println(findLengthOfShortestSubarray(new int[] {1, 2, 3}));
    System.out.println(findLengthOfShortestSubarray(new int[] {2, 2, 2, 1, 1, 1}));
    System.out.println(findLengthOfShortestSubarray(new int[] {1, 2, 3, 3, 10, 1, 3, 3, 5}));
  }
}
