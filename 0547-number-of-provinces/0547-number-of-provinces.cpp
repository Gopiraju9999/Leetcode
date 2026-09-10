class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        vector<bool>visited(n, false);
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                DFS(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }
    void DFS(int city, vector<vector<int>> &isConnected, vector<bool>& visited){
        visited[city] = true;

        for(int curr = 0; curr < isConnected[city].size(); curr++){
            if(isConnected[city][curr] == 1 && !visited[curr]){
                DFS(curr, isConnected, visited);
            }
        }
    }
};