class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1 && DFS(grid1, grid2, i, j, m, n))
                    count++;
            }
        }
        return count;
    }
    
    // This is for checking the every single step in "Grid1" && "Grid2"
    private boolean DFS(int[][] grid1, int[][] grid2, int i, int j, int m, int n){

        if(i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) return true;

        grid2[i][j] = 0;
        boolean result = (grid1[i][j] == 1);

        // "&=" means it checks the previous one and current. Both should pass
        result &= DFS(grid1, grid2, i-1, j, m, n);
        result &= DFS(grid1, grid2, i+1, j, m, n);
        result &= DFS(grid1, grid2, i, j-1, m, n);
        result &= DFS(grid1, grid2, i, j+1, m, n);

        return result;
    }
}