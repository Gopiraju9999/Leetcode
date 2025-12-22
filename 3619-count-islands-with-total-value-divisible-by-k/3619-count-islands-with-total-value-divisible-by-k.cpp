class Solution {
public:
    long long DFS(vector<vector<int>>& grid, int i, int j, int m, int n){
        if(i<0 || i>= m || j<0 || j>= n || grid[i][j] == 0) return 0;

        long long sum = grid[i][j];  // Storing the value at current cell
        grid[i][j] = 0;       // Mark it as visited..

        sum += DFS(grid, i-1, j, m, n);
        sum += DFS(grid, i+1, j, m, n);
        sum += DFS(grid, i, j-1, m, n);
        sum += DFS(grid, i, j+1, m, n);

        return sum;
    }
    int countIslands(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        long long sum = 0;

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
};