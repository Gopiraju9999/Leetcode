class Solution {
public:
    void DFS(int city, vector<vector<int>>& isConnected, unordered_set<int>& visited){
        visited.insert(city);
        for(int curr = 0; curr < isConnected[city].size(); curr++){
            int connected = isConnected[city][curr];
            if(connected == 1 && visited.find(curr) == visited.end()){
                DFS(curr, isConnected, visited);
            }
        }
    }
    // Traversal Function for DFS. It traverses the vertices, if it ends cnt++ & exit
    int findCircleNum(vector<vector<int>>& isConnected) {
        unordered_set<int>visited;
        int count = 0;

        for(int i = 0; i < isConnected.size(); i++){
            if(visited.find(i) == visited.end(i)){
                DFS(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }
};