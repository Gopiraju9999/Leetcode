class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;        // for columns
        int n = grid[0].length;     // for rows
        Queue<int[]>q = new LinkedList<>();
        int fresh_count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh_count++;
                }
            }
        }
        if(fresh_count == 0) return 0;
        int minutes = 0;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while(!q.isEmpty()){
            int size = q.size();

            for(int k = 0; k < size; k++){
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];

                for(int[] dir : directions){
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    if(isValid(new_i, new_j, m, n) && grid[new_i][new_j] == 1){
                        // Make rotten
                        grid[new_i][new_j] = 2;
                        // Push their adjacent 4 direction cells having "1"
                        q.offer(new int[]{new_i, new_j});
                        // And decrement the freshcount. Because,fresh became rotten
                        fresh_count--;
                    }
                }
            }
            minutes++;
        }
        // At the end, any of fresh orange is remained. 
        //It means their is a orange lies btw empty cells & couldn't become rotten
        return (fresh_count == 0) ? (minutes - 1) : -1;
    }
    private boolean isValid(int i, int j, int m, int n){
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}