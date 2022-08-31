/*
Pots of Gold Game
Two players X and Y are playing a game in which there are pots of gold arranged in a line, each containing some gold coins. They get alternating turns in which the player can pick a pot from one of the ends of the line. The winner is the player who has a higher number of coins at the end. The objective is to maximize the number of coins collected by X, assuming Y also plays optimally.

Return the maximum coins X could get while playing the game. Initially, X starts the game.
Example 1:
Input:
N = 4
Q[] = {8, 15, 3, 7}
Output: 22
Explanation: Player X starts and picks 7. Player Y 
picks the pot containing 8. Player X picks the pot
containing 15. Player Y picks 3.
Total coins collected by X = 7 + 15 = 22.
*/
class Solution
{
	public static int maxCoins(int A[],int n)
	{
          //add code here.
          int[][] lookup = new int[n][n];
          return findMaxCoins(A,0,n-1,lookup);
    }
    public static int findMaxCoins(int[] coin, int i, int j, int[][] lookup)
    {
        // base case: one pot left, only one choice possible
        if (i == j) {
            return coin[i];
        }
 
        // if we are left with only two pots, choose one with maximum coins
        if (i + 1 == j) {
            return Integer.max(coin[i], coin[j]);
        }
 
        // if the subproblem is seen for the first time, solve it and
        // store its result in a lookup table
        if (lookup[i][j] == 0)
        {
            // if a player chooses the front pot `i`, the opponent is left to choose
            // from [i+1, j].
            // 1. If the opponent chooses front pot `i+1`, recur for [i+2, j]
            // 2. If the opponent chooses rear pot `j`, recur for [i+1, j-1]
 
            int start = coin[i] + Integer.min(findMaxCoins(coin, i + 2, j, lookup),
                            findMaxCoins(coin, i + 1, j - 1, lookup));
 
            // if a player chooses rear pot `j`, the opponent is left to choose
            // from [i, j-1].
            // 1. If the opponent chooses front pot `i`, recur for [i+1, j-1]
            // 2. If the opponent chooses rear pot `j-1`, recur for [i, j-2]
 
            int end = coin[j] + Integer.min(findMaxCoins(coin, i + 1, j - 1, lookup),
                            findMaxCoins(coin, i, j - 2, lookup));
 
            // assign a maximum of two choices
            lookup[i][j] = Integer.max(start, end);
        }
 
        // return the subproblem solution from the map
        return lookup[i][j];
    }
}
