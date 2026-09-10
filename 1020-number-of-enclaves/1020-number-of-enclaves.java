class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;        // "m" is for column 
        int n = grid[0].length;     // "n" is for rows
        int count = 0;

        // Check 1st & last columns
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                DFS(i, 0, m, n, grid);
            }
            if(grid[i][n-1] == 1){
                DFS(i, n-1, m, n, grid);
            }
        }

        // check 1st & last rows
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1){
                DFS(0, j, m, n, grid);
            }
            if(grid[m-1][j] == 1){
                DFS(m-1, j, m, n, grid);
            }
        }

        // Now, calculate the Enclaves..
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    private void DFS(int i, int j, int m, int n, int[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) return;

        grid[i][j] = 0;  // Means, got 1 at boundary. Make it 0 for proper calculation

        // Possible moves
        DFS(i+1, j, m, n, grid);
        DFS(i-1, j, m, n, grid);
        DFS(i, j+1, m, n, grid);
        DFS(i, j-1, m, n, grid);
    }
}