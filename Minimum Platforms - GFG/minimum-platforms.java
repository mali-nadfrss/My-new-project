//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dept[], int n)
    {
        // add your code here
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int[][] sched = new int[n][2];

    for (int i = 0; i < n; i++) {
      sched[i][0] = arr[i];
      sched[i][1] = dept[i];
    }
    
    Arrays.sort(sched, Comparator.comparingInt(o -> o[0]));

    int ans = 0;
    for (int i = 0; i < n; i++) {
      while (!pq.isEmpty() && pq.peek() < sched[i][0]) {
        pq.poll();
      }
      pq.add(sched[i][1]);
      ans = Math.max(ans, pq.size());
    }
    return ans;
    }
    
}

