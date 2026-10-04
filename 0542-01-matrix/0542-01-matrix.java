class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]>que = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    que.offer(new int[]{i,j, 0});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while(!que.isEmpty()){
            int[] node = que.poll();
            int i = node[0];
            int j = node[1];

            for(int[] dir : directions){
                int new_i = i + dir[0];
                int new_j = j + dir[1];

                if(isValid(new_i, new_j, m, n) && mat[new_i][new_j] == -1){
                    mat[new_i][new_j] = mat[i][j] + 1;
                    que.offer(new int[]{new_i, new_j});
                }
            }
        }
        return mat;
    }

    private boolean isValid(int i, int j, int m, int n){
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}