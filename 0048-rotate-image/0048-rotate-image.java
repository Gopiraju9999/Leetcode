class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[m][n];

        // Firstly, Transpose the matrix 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[j][i] = matrix[i][j];
            }
        }

        // Reverse every row
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = result[i][n-1-j];
            }
        }
    }
}