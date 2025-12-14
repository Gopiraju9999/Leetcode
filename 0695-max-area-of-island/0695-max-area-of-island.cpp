class Solution {
public:
    int DFS(vector<vector<int>>& grid, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        
        int area = 1;

        // For every DFS call, increse the count of island
        area += DFS(grid, i-1, j, m, n);
        area += DFS(grid, i+1, j, m, n);
        area += DFS(grid, i, j-1, m, n);
        area += DFS(grid, i, j+1, m, n);

        return area;
    }
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int max_area = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                   int area = DFS(grid, i, j, m, n);
                    max_area = max(max_area, area);
                }
            }
        }
        return max_area;
    }
};