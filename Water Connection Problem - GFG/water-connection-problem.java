//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            ArrayList<Integer> d = new ArrayList<Integer>();
            
            for(int i=0;i<p;i++)
            {
                a.add(sc.nextInt());
                b.add(sc.nextInt());
                d.add(sc.nextInt());
            }
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.solve(n, p, a, b, d); 
            System.out.println(ans.size());
            for (int i=0;i<ans.size();i++){ 
                System.out.println(ans.get(i).get(0)+" "+ans.get(i).get(1)+" "+ans.get(i).get(2)); 
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,ArrayList<Integer> b ,ArrayList<Integer> d) 
    { 
         // code here
         
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        Map<Integer, int[]> map = new HashMap<>();
        int[] indegree = new int[n+1];
        
        for(int i = 0; i < p ; i++){
            map.put(a.get(i), new int[] {a.get(i), b.get(i), d.get(i)});
            indegree[b.get(i)]++;
        }
        
    
        
       for(int i = 1 ; i <= n ; i++){
           
           if(indegree[i] == 0  && map.get(i) != null){
               ArrayList<Integer> temp = new ArrayList<>();
               temp.add(i);
               ans.add(temp);
               calculate(temp, map.get(i)[2], map.get(i)[1], map);
           }
           
       }
       return ans;
        
        
         
     }
     
     void calculate(ArrayList<Integer> temp, int min, int index, Map<Integer, int[]> map){
         if(map.get(index) == null){
             temp.add(index);
             temp.add(min);
             return;
         }
         min = Math.min(map.get(index)[2], min);
         calculate(temp, min, map.get(index)[1], map);
     }
} 