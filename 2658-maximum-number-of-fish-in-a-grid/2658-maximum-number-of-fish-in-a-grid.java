class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxi_fishes = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    int fishes = DFS(grid, i, j, m, n);
                    maxi_fishes = Math.max(maxi_fishes, fishes);
                }
            }
        }
        return maxi_fishes;
    }

    private int DFS(int[][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;

        int fishes = grid[i][j];  // Take that cell fishes as initial fishes
        grid[i][j] = 0;           // And make the cell as "0" for good calculation

        fishes += DFS(grid, i+1, j, m, n);
        fishes += DFS(grid, i-1, j, m, n);
        fishes += DFS(grid, i, j+1, m, n);
        fishes += DFS(grid, i, j-1, m, n);

        return fishes;
    }
}