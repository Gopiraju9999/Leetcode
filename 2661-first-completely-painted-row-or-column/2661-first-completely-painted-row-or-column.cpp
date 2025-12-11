class Solution {
    #define pii pair<int, int>
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();

        vector<int>row_ones(m,0), col_ones(n,0);
        vector<pii>lookup(m*n+1);  // Stores like {key, value} for easy identification

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                lookup[mat[i][j]] = make_pair(i,j);
            }
        }

        for(int i = 0; i < m*n; i++){
            pii coor = lookup[arr[i]];

            int x = coor.first;
            int y = coor.second;

            row_ones[x]++;
            col_ones[y]++;

            if(row_ones[x] == n || col_ones[y] == m)
                return i;
        }
        return 0;
    }
};