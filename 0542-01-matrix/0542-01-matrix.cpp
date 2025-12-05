class Solution {
public:
    int m, n;
    vector<vector<int>>direction{{0,1}, {0,-1}, {1,0}, {-1,0}};
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        m = mat.size();
        n = mat[0].size();

        vector<vector<int>>result(m, vector<int>(n, -1));
        queue<pair<int, int>>q;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    result[i][j] = 0;
                    q.push({i,j});
                }
            }
        }
        while(!q.empty()){
            auto p = q.front();
            q.pop();

            int i = p.first;
            int j = p.second;
            for(auto &dir : direction){
                int new_i = i + dir[0]; // Choosing the correct way of pair {i,j}
                int new_j = j + dir[1]; 

                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && 
                result[new_i][new_j] == -1){
                    result[new_i][new_j] = 1 + result[i][j];
                    q.push({new_i, new_j});
                }
            }
        }
        return result;
    }
};