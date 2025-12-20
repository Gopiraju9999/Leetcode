class Solution {
    private void DFS(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != 0) return;

        // grid[i][j] != 0 means 
        grid[i][j] = 1; // Mark it as visited.. 
        DFS(grid, i-1, j);
        DFS(grid, i+1, j);
        DFS(grid, i, j-1);
        DFS(grid, i, j+1);
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int island_count = 0;

        // Checking for 1st and last Rows..
        for(int j = 0; j < n; j++){
            DFS(grid, 0, j);
            DFS(grid, m-1, j);
        }

        // Checking for 1st and last Columns..
        for(int i = 0; i < m; i++){
            DFS(grid, i, 0);
            DFS(grid, i, n-1);
        }

        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n-1; j++){
                if(grid[i][j] == 0)
                    island_count++;
                    DFS(grid, i, j);
            }
        }
        return island_count;
    }
}