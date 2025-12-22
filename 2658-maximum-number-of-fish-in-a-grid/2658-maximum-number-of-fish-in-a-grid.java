class Solution {
    private int DFS(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i >=m || j<0 || j>=n || grid[i][j] == 0) return 0;

        int fish = grid[i][j];   // Store the value
        grid[i][j] = 0;            // Mark as visited..

        fish += DFS(grid, i-1, j, m, n);
        fish += DFS(grid, i+1, j, m, n);
        fish += DFS(grid, i, j-1, m, n);
        fish += DFS(grid, i, j+1, m, n);

        return fish;
    }
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fishes = 0, maxi = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    fishes = DFS(grid, i, j, m, n); // Way to run DFS and stores values with DFS
                    maxi = Math.max(maxi, fishes);
                }
            }
        }
        return maxi;
    }
}