class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int N = m*n;

        int[] row_ones = new int[m];
        int[] col_ones = new int[n];

        Map<Integer, int[]>lookup = new HashMap<>(); // Create Hashmap for pair{i, j}
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                lookup.put(mat[i][j], new int[]{i,j}); // This is the way to pair {i, j} 
            }
        }

        for(int i = 0; i < N; i++){
            int[] coor = lookup.get(arr[i]);

            int x = coor[0]; // like coor.first
            int y = coor[1]; // like coor.second

            row_ones[x]++;
            col_ones[y]++;

            if(row_ones[x] == n || col_ones[y] == m) // Checking for row or column Fill
                return i;
        }
        return 0;
    }
}