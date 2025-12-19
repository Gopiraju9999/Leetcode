class Solution {
public:
    void DFS(vector<vector<int>>& grid, int i, int j){
        if(i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] != 0) return;

        grid[i][j] = 1;
        DFS(grid, i-1, j);
        DFS(grid, i+1, j);
        DFS(grid, i, j-1);
        DFS(grid, i, j+1);
    }
    
    int closedIsland(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size(); 
        int island_count = 0;

        // Checking the 1st and last Columns having 0's..
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 0)
                DFS(grid, 0, j);
            if(grid[m-1][j] == 0)
                DFS(grid, m-1, j);
        }

        // Checking the 1st and last rows having 0's.. 
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 0)
                DFS(grid, i, 0);
            if(grid[i][n-1] == 0)
                DFS(grid, i, n-1);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0)
                    island_count++;
                    DFS(grid, i, j);
            }
        }
        return island_count;
    }
};