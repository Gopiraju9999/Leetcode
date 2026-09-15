class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        Queue<int[]>q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    isWater[i][j] = 0;
                    q.offer(new int[]{i, j});
                }else{
                    isWater[i][j] = -1;
                }
            }
        }

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

                    if(isValid(new_i, new_j, m, n) && isWater[new_i][new_j] == -1){
                        isWater[new_i][new_j] = isWater[i][j] + 1;;
                        q.offer(new int[]{new_i, new_j});
                    }
                }
            }
        }
        return isWater;
    }
    private boolean isValid(int i, int j, int m, int n){
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}