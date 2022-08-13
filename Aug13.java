
/*
Max length chain
You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. You have to find the longest chain which can be formed from the given set of pairs. 
 

Example 1:

Input:
N = 5
P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
Output: 3
Explanation: The given pairs are { {5, 24}, {39, 60},
{15, 28}, {27, 40}, {50, 90} },the longest chain that
can be formed is of length 3, and the chain is
{{5, 24}, {27, 40}, {50, 90}}
*/
/*class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}*/

class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
       // your code here
       //TC-O(NlogN)
       //SC_O(N)
       Arrays.sort(arr,(a,b)->a.y-b.y);
       int ans = 1;
       int prev = arr[0].y;
       for(int i=1;i<n;i++){
           if(arr[i].x>prev){
               prev = arr[i].y;
               ans++;
           }
       }
       return ans;
       /*
       //TLE
       //TC-O(N^2)
       //SC-O(N)
       Arrays.sort(arr,(a,b)->a.x-b.x);
       int[] dp = new int[n];
       Arrays.fill(dp,1);
       int ans = 1;
       
       for(int i=n-2;i>=0;i--){
           for(int j=i+1;j<n;j++){
               if(arr[j].x>arr[i].y){
                   dp[i] = Math.max(dp[i],dp[j]+1);
                   ans = Math.max(ans,dp[i]);
               }
           }
       }
       return ans;
       */
    }
}
