class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    DFS(grid, i, j, m, n); // Run DFS call for another 1's as island
                } 
            }
        }
        return count;
    }

    private void DFS(char[][] grid, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;

        grid[i][j] = '0';   // Mark it as visited..
        DFS(grid, i-1, j, m, n);
        DFS(grid, i+1, j, m, n);
        DFS(grid, i, j-1, m, n);
        DFS(grid, i, j+1, m, n);
    }
}