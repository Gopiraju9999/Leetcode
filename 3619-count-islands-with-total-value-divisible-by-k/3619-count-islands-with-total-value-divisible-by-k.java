class Solution {
    private long DFS(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0) return 0;

        long sum = grid[i][j];
        grid[i][j] = 0;

        sum += DFS(grid, i-1, j, m, n);
        sum += DFS(grid, i+1, j, m, n);
        sum += DFS(grid, i, j-1, m, n);
        sum += DFS(grid, i, j+1, m, n);

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        long sum = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    sum = DFS(grid, i, j, m, n);
                    if(sum % k == 0)
                        count++;
                }
            }
        }
        return count;
    }
}