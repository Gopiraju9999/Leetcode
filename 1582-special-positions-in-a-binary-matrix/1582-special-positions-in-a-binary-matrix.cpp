class Solution {
public:
    int numSpecial(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();

        vector<int>row_ones(m,0); // Keeps tracking 1's in every row
        vector<int>col_ones(n,0); // Keeps tracking 1's in every column

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 1){
                    row_ones[i]++;  // If Current row is having "1" and increament to "1"
                    col_ones[j]++;  // If current column having "1" and increment to "1"
                }
            }
        }

        // Now, we should have both vectors respective positions "1". Then increment special++

        int special_posi = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1 && row_ones[i] == 1 && col_ones[j] == 1){
                    special_posi++;
                }
            }
        }
        return special_posi;
    }
};