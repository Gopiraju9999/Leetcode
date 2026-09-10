class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    DFS(i, j, m, n, grid);
                }
            }
        }
        return count;
    }
    private void DFS(int i, int j, int m, int n, char[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;

        grid[i][j] = '0'; // Mark as visited

        // Now, make 4 moves (left, right, up, down)
        // These 4 moves checks the islands..
        DFS(i+1, j, m, n, grid);
        DFS(i-1, j, m, n, grid);
        DFS(i, j+1, m, n, grid);
        DFS(i, j-1, m, n, grid);
    }
}