/*
Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.If it cannot reach the target position return -1.

Note:
The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.
Example 1:
Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
*/
class Pair{
    int i;
    int j;
    int dist;
    Pair(int i,int j,int d){
        this.i = i;
        this.j = j;
        this.dist = d;
    }
}
class Solution
{
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int[] x = new int[]{1,1,2,2,-1,-1,-2,-2};
        int[] y = new int[]{2,-2,1,-1,2,-2,1,-1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(KnightPos[0],KnightPos[1],0));
        boolean[][] vis = new boolean[N+1][N+1];
        vis[KnightPos[0]][KnightPos[1]] =true;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair curr = q.remove();
                int i = curr.i;
                int j = curr.j;
                int dist = curr.dist;
                if(i==TargetPos[0] && j==TargetPos[1]) return dist;
                for(int k=0;k<8;k++){
                    if(isValid(i+x[k],j+y[k],N,vis)){
                        q.add(new Pair(i+x[k],j+y[k],dist+1));
                        vis[i+x[k]][j+y[k]] = true;
                    }
                }
            }
        }
        return -1;
    }
    boolean isValid(int i,int j,int N, boolean[][] vis){
        if(i<1 || j<1 || i>N || j>N || vis[i][j]) 
            return false;
        
        return true;
    }
}
