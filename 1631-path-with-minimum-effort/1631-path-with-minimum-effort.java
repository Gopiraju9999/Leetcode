class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);


        PriorityQueue<int[]>pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        pq.offer(new int[] {0, 0, 0});
        dist[0][0] = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == n-1 && c == m-1){
                return effort;
            }

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m){
                    continue;
                }
                
                int neweffort = Math.max(
                    effort, 
                    Math.abs(heights[r][c] - heights[nr][nc])
                );

                if(neweffort < dist[nr][nc]){
                    dist[nr][nc] = neweffort;
                    pq.offer(new int[] {neweffort, nr, nc});
                }
            }
        }
        return 0;
    }
}