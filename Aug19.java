/*
Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
Region of 1's is a group of 1's connected 8-directionally (horizontally, vertically, diagonally).
 

Example 1:

Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
Output: 5
Explanation: The grid is-
1 1 1 0
0 0 1 0
0 0 0 1
The largest region of 1's is colored
in orange.
Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
 Constraints:
1 ≤ n, m ≤ 500
*/
class Solution
{
    int count;
    //Function to check if a given cell (row, col) can be included in DFS.
    static boolean isSafe(int[][] M,int row,int col,boolean[][] visited,int ROW,int COL)
    {
        //if the cell is within the matrix bounds and value at cell is 1 and
        //the cell is not visited, we return true else false.
        return ((row >= 0)&&(row<ROW)&&(col>=0)&& (col < COL)
                             && (M[row][col] == 1 && !visited[row][col]));
    }

    
    void DFS(int[][] M,int row,int col,boolean[][] visited,int ROW,int COL)
    {
        //these arrays are used to get row and column numbers
        //of 8 neighbours of a given cell.
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        //marking the current cell as visited.
        visited[row][col] = true;

        //iterating over the adjacent cells.
        for (int k = 0; k < 8; k++) 
        {
            //if cell indexes are within range, we increment the count
            //and call the function recursively.
            if (isSafe(M, row + dx[k], col + dy[k],visited, ROW, COL)) 
            {
                count++;
                DFS(M, row + dx[k], col + dy[k],visited, ROW, COL);
            }
        }
    }
    
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int ROW = grid.length;
        int COL = grid[0].length;
        
        //using boolean array to mark visited nodes.
        boolean[][] visited = new boolean[ROW][COL];

        int result = 0;
        //traversing all the cells of the matrix.
        for (int i = 0; i < ROW; i++) 
        {
            for (int j = 0; j < COL; j++) 
            {
                //if a cell has value 1 is not visited, we call DFS function.
                if (grid[i][j] == 1 && !visited[i][j]) 
                {
                    count = 1;
                    DFS(grid, i, j, visited, ROW, COL);

                    //updating maximum area.
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
}
//Approach-2
class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    ans = Math.max(ans,dfs(i,j,visited,grid));
                }
            }
        }
        return ans;
    }
    int dfs(int i,int j,boolean[][]visited,int[][]grid){
        if(!valid(i,j,grid,visited)) 
            return 0;
            
        visited[i][j] = true;
        int count = 1;
        
        count+=dfs(i+1,j,visited,grid);
        count+=dfs(i-1,j,visited,grid);
        count+=dfs(i,j+1,visited,grid);
        count+=dfs(i,j-1,visited,grid);
        count+=dfs(i+1,j+1,visited,grid);
        count+=dfs(i-1,j-1,visited,grid);
        count+=dfs(i+1,j-1,visited,grid);
        count+=dfs(i-1,j+1,visited,grid);
        
        return count;
    }
    
    boolean valid(int i,int j,int[][]grid,boolean[][]visited){
        
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || visited[i][j] || grid[i][j]==0)
            return false;
            
        return true;    
    }
}
//Diffrent boolean func
class Solution
{
    int count;
    //Function to check if a given cell (row, col) can be included in DFS.
    static boolean isSafe(int[][] grid,int row,int col,boolean[][] visited,int ROW,int COL)
    {
        //if the cell is within the matrix bounds and value at cell is 1 and
        //the cell is not visited, we return true else false.
        if(row<0 || col<0 || row>=ROW || col>=COL || visited[row][col] || grid[row][col]==0)
            return false;
        return true;    
    }

    
    void DFS(int[][] grid,int row,int col,boolean[][] visited,int ROW,int COL)
    {
        //these arrays are used to get row and column numbers
        //of 8 neighbours of a given cell.
        int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

        //marking the current cell as visited.
        visited[row][col] = true;

        //iterating over the adjacent cells.
        for (int k = 0; k < 8; k++) 
        {
            //if cell indexes are within range, we increment the count
            //and call the function recursively.
            if (isSafe(grid, row + x[k], col + y[k],visited, ROW, COL)) 
            {
                count++;
                DFS(grid, row + x[k], col + y[k],visited, ROW, COL);
            }
        }
    }
    
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int ROW = grid.length;
        int COL = grid[0].length;
        
        //using boolean array to mark visited nodes.
        boolean[][] visited = new boolean[ROW][COL];

        int result = 0;
        //traversing all the cells of the matrix.
        for (int i = 0; i < ROW; i++) 
        {
            for (int j = 0; j < COL; j++) 
            {
                //if a cell has value 1 is not visited, we call DFS function.
                if (grid[i][j] == 1 && !visited[i][j]) 
                {
                    count = 1;
                    DFS(grid, i, j, visited, ROW, COL);

                    //updating maximum area.
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
}

    
   
