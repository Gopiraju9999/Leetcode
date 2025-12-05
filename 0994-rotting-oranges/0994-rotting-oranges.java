class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh_count = 0;
        Queue<int[]>que = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    que.offer(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    fresh_count++;
                }
            }
        }

        if(fresh_count == 0) return 0;
        int minutes = 0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int[] curr = que.poll(); // poll => Takes the front one & pop out
                int i = curr[0];
                int j = curr[1];

                for(int[] dir : directions){
                    // Choose there Neighbourss..
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && 
                    grid[new_i][new_j] == 1){
                        grid[new_i][new_j] = 2;
                        fresh_count--;
                        que.offer(new int[]{new_i, new_j});
                    }
                }
            }
            minutes++;
        }
        return fresh_count == 0 ? (minutes - 1) : -1;
    }
}