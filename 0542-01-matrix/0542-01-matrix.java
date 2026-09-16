class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]>que = new LinkedList<>();
        int[][] visited = new int[m][n];
        int[][] distance = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    que.offer(new int[]{i, j, 0}); // {i,j,0} 0 means distance from "0".
                    visited[i][j] = 1;  // Mark as visited
                }else{
                    visited[i][j] = 0;   // Mark as not visited
                }
            }
        }
        
        // 4 directions {up, down, lefft, right}
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while(!que.isEmpty()){

            int[] node = que.poll();      // Getting and poping the first element from queue
            int i = node[0];
            int j = node[1];
            int steps = node[2];

            distance[i][j] = steps;

            for(int[] dir : directions){
                int new_i = i + dir[0];
                int new_j = j + dir[1];

                if(isValid(new_i, new_j, m, n) && visited[new_i][new_j] == 0){
                    visited[new_i][new_j] = 1;      // Mark as visited
                    que.offer(new int[]{new_i, new_j, steps+1});
                }
            }
        }
        return distance;
    }
    private boolean isValid(int i, int j, int m, int n){
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}