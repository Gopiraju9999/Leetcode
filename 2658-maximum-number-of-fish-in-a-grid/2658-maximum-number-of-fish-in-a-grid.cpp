class Solution {
public:
    int DFS(vector<vector<int>>& grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0) 
            return 0;

        int fish = grid[i][j]; // Stores the fishes at the cell 
        grid[i][j] = 0;          // Mark as visited..

        fish += DFS(grid, i-1, j, m, n);
        fish += DFS(grid, i+1, j, m, n);
        fish += DFS(grid, i, j-1, m ,n);
        fish += DFS(grid, i, j+1, m, n);

        return fish;
    }
    int findMaxFish(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int fishes = 0, maxi = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    fishes = DFS(grid, i, j, m, n); // Way to call DFS & stores the value..
                    maxi = max(maxi, fishes);
                }
            }
        }
        return maxi;
    }
};