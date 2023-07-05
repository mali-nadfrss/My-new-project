//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int[][] meetings = new int[n][2];
        
        for(int i = 0 ; i < n ; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        
        Arrays.sort(meetings, Comparator.comparingInt(o-> o[1]));
        int meetingIndex = 0;
        int ans = 1;
        for(int i = 1 ; i < n ; i++){
            if(meetings[i][0] > meetings[meetingIndex][1] ){
                ans++;
                meetingIndex = i;
            }
        }
        
        return ans;
        
    }
}
