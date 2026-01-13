class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>>adj(numCourses);
        vector<int>indegree(numCourses, 0);

        // Common stepfirstly push into adjacency list and calulate the incoming edges(indegree)
        for(auto it : prerequisites){
            int course = it[0];
            int prereq = it[1];
            adj[prereq].push_back(course);
            indegree[course]++;
        }

        // From here, The Topological procedure will start..
        // Where the indegree has "0", Push them into queueee..
        queue<int>q;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                q.push(i);
        }

        vector<int>topo;

        while(!q.empty()){
            int node = q.front();
            q.pop();
            topo.push_back(node);

            for(auto it : adj[node]){
                indegree[it]--;            //  Initially, decrease the value& check for "0"
                if(indegree[it] == 0)
                    q.push(it);
            }
        }
        if(topo.size() != numCourses)
            return {};

        return topo;
    }
};