class Solution {
    public void rotate(int[][] matrix) {
        // 90 degrees clockwise direction => Transpose + Reverse Every Row..
        // First transpose the given matrix (Rows -> columns,  columns -> Rows)
        // Reverse Every Row. Then, the resulting matrix will be the 90 degrees clockwise matrix

        int m = matrix.length, n = matrix[0].length;

        // Way to transpose..
        for(int i = 0; i < m; i++){
            for(int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // way to reverse every row
        for(int i = 0; i < n; i++){
            int l = 0, r = n-1;

            while(l <= r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}