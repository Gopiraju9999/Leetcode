class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] row_ones = new int[m];
        int[] col_ones = new int[n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 1){
                    row_ones[i] += 1;
                    col_ones[j] += 1;
                }
            }
        }

        int special_posi = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1 && row_ones[i] == 1 && col_ones[j] == 1){
                    special_posi++;
                }
            }
        }
        return special_posi;
    }
}