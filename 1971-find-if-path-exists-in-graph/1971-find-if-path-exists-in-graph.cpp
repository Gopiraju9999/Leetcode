class Solution {
public:
    bool DFS(int node, int destination, vector<vector<int>>& adj, vector<bool>& visited){
        if(node == destination) return true;

        visited[node] = true; // Make that node as visited

        for(int nei : adj[node]){
            if(!visited[nei])
                if(DFS(nei, destination, adj, visited))
                    return true;
        }
        return false;
    }
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<vector<int>>adj(n); // Adjacency list for graph

        for(auto& e : edges){
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<bool>visited(n, false); // Vector for checking visit or not?? 1stly make unvisit
        return DFS(source, destination, adj, visited);
    }
};