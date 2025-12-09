class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        vector<int>rowones(m,0);
        vector<int>colones(n,0);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowones[i] += 1;
                    colones[j] += 1;
                }
            }
        }

        vector<vector<int>>diff(m, vector<int>(n,0));

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int onesRowi = rowones[i];
                int onesColj = colones[j];
                int zerosRowi = m - rowones[i];
                int zerosColj = n - colones[j];

                diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj;
            }
        }
        return diff;
    }
};