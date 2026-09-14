class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        Queue<int[]>q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] height = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];

                for(int[] dir : directions){
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    if(isValid(new_i, new_j, m, n) && !visited[new_i][new_j]){
                        q.offer(new int[]{new_i, new_j});
                        height[new_i][new_j] = level + 1;;
                        visited[new_i][new_j] = true;
                    }
                }
            }
            level++;
        }
        return height;
    }
    private boolean isValid(int i, int j, int m, int n){
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}