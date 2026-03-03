class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] column = new int[n];

        // This nested loop job is make the respective R & C == 0 => "1"
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){  // If the cell [i][j] == 0.Then, change R & C with "1".
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        // If the R || C anyone is having "1". Then, the entire row or column make "0". 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] == 1 || column[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}