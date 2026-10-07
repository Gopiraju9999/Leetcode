class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] column = new int[n];

        // Check each and every cell in a matrix, if the cell equals to "0"
        // Mark it the respective row number & column number as "1"
        // The marking will helps us to "Set Matrix Zero"
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        // Now, we have to check the row & column arrays has "1"
        // EX:- row 0 1 0,    column 0 1 0
        // Here, we have to make the entire row & column "0" where the array index having "0"

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // It means whether the row or column has "1"
                // Make that respective row or column as "0"
                if(row[i] == 1 || column[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        } 
    }
}