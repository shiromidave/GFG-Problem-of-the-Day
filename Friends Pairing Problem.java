/*
Friends Pairing Problem
Given N friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
Note: Since answer can be very large, return your answer mod 10^9+7.
Input:N = 3
Output: 4
Explanation:
{1}, {2}, {3} : All single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.
*/
//Iterative
class Solution
{
    int m = 1000000007;
    public long countFriendsPairings(int n) 
    { 
        long a = 1, b = 2, c = 0; 
    	if (n <= 2) { 
    		return n; 
    	} 
    	for (int i = 3; i <= n; i++)
    	{ 
    	    // using modular arithmentic properties.
    		c = ( b%m + ( ( (i - 1)%m  *  a%m )%m ) %m )%m ; 
    		a = b; 
    		b = c; 
    	} 
    	return c; 
    }
};    
//DP approach
 class Solution
{
    public long countFriendsPairings(int n) 
    {
       long mod = 1000000007;
       long[] dp = new long[n+1];
       return helper(n,dp,mod);
    }
    long helper(int n,long[] dp,long mod){
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];
        return dp[n] = (helper(n-1,dp,mod) + ((n-1)*helper(n-2,dp,mod)))%mod;
    }
    
}   
 
