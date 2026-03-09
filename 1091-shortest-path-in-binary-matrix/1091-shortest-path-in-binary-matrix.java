class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Impossible case..
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        // Setting directions on 8 sides of cell..
        int[][] direction = {
            {1,0}, {-1,0}, {0,1}, {0,-1},
            {1,1}, {1,-1}, {-1,1}, {-1,-1}
        };

        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1;     // Mark visited
        int path_len = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int s = 0; s < size; s++){
                int[] cell = q.poll();
                int i = cell[0], j = cell[1];

                // Final Destination
                if(i == n-1 && j == n-1) return path_len;

                for(int[] dir : direction){
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    // These are the base cases, Like Out of Bounds conditions..
                    if(new_i >= 0 && new_j >= 0 && new_i < n && new_j < n && 
                    grid[new_i][new_j] == 0){
                        q.offer(new int[]{new_i, new_j});
                        grid[new_i][new_j] = 1;   // Mark Visited
                    }
                }
            }
            path_len++;
        }
        return -1;
    } 
}