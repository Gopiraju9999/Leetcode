class Solution {
public:
    typedef pair<int,int>p;
    vector<vector<int>>directions{{-1,0}, {1,0}, {0,-1}, {0,1}}; // Direction ULDR
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();  // Size of row
        int n = grid[0].size(); // Size of every line column

        queue<p>q;
        int fresh_count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.push({i,j});
                } else if(grid[i][j] == 1){
                    fresh_count++;
                }
            }
        }

        if(fresh_count == 0) return 0; // Already rotten oragnes are there..
        int minutes = 0;

        while(!q.empty()){
            int N = q.size();
            while(N--){
                p curr = q.front();
                q.pop();

                int i = curr.first;
                int j = curr.second;
                for(auto &dir : directions){
                    // Finding there neighbours.. Like "URDL"
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n &&
                    grid[new_i][new_j] == 1){ 
                        grid[new_i][new_j] = 2; // Make those neighbours as rotten
                        fresh_count--;
                        q.push({new_i, new_j}); // add new rotten ones into queue
                    }
                }
            }
            minutes++;
        }
        return fresh_count == 0 ? (minutes - 1) : -1;
    }
};