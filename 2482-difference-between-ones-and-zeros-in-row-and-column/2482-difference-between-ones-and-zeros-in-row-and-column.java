class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowones = new int[m];
        int[] colones = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowones[i] += 1;
                    colones[j] += 1;
                }
            }
        }

        int[][] diff = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int onesRowi = rowones[i];
                int onesColj = colones[j];
                int zerosRowi = m - rowones[i];
                int zerosColj = n - colones[j];
                diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj;
            }
        }
        return diff;
    }
}