class Solution {
    // This main function job is to pick 1st or starting node of 1 province
    // Make a DFS call for nodes visit
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            // Node is not visited, go and visit all the neighbouring nodes as well
            if(!visited[i]){
                DFS(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }
    // This supportive functions job is to do all neighbouring nodes visited..
    private void DFS(int city, int[][] isConnected, boolean[] visited){
        visited[city] = true;
        
        // "isConnected[city].length" similar to matrix[0].length
        // It traverses every rowwise also, (it searches all nodes in a province)
        // After traversing all nodes in a province. Go back to main function&another proviince
        for(int curr = 0; curr < isConnected[city].length; curr++){
            if(isConnected[city][curr] == 1 &&  !visited[curr]){
                DFS(curr, isConnected, visited);
            }
        }
    }
}