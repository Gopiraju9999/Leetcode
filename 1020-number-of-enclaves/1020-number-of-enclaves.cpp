class Solution {
public:
    void DFS(vector<vector<int>>& grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) return;

        grid[i][j] = 0;
        DFS(grid, i-1, j, m, n);
        DFS(grid, i+1, j, m, n);
        DFS(grid, i, j-1, m, n);
        DFS(grid, i, j+1, m, n);
    }
    int numEnclaves(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1)
                DFS(grid, i, 0, m, n);
            if(grid[i][n-1] == 1)
                DFS(grid, i, n-1, m, n);
        }

        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1)
                DFS(grid, 0, j, m, n);
            if(grid[m-1][j] == 1)
                DFS(grid, m-1, j, m, n);
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
};