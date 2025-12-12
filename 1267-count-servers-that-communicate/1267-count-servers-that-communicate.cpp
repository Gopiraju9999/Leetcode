class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<int>row(m,0), column(n,0);
        int total_count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    row[i]++;
                    column[j]++;
                    total_count++;
                }
            }
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // Which means having only single computer (row == 1 && column == 1)
                // Like 1 computer is having none computers its 4 directions

                if(grid[i][j] == 1 && (row[i] == 1 && column[j] == 1)){
                    total_count--;
                }
            }
        }
        return total_count;
    }
};