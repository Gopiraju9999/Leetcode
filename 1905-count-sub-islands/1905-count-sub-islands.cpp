class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int m = grid2.size();
        int n = grid2[0].size();
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1)
                    if(DFS(grid1, grid2, i, j, m, n))
                        count++;
            }
        }
        return count;
    }
    bool DFS(vector<vector<int>>&grid1, vector<vector<int>>& grid2, int i, int j, int m, int n){

        if(i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) return true;

        grid2[i][j] = 0;
        bool result = (grid1[i][j] == 1);

       result &= DFS(grid1, grid2, i-1, j, m, n);
       result &= DFS(grid1, grid2, i+1, j, m, n);
       result &= DFS(grid1, grid2, i, j-1, m, n);
       result &= DFS(grid1, grid2, i, j+1, m, n);

       return result;
    }
};