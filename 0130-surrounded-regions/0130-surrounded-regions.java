class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O')
                DFS(board, i, 0, m, n);
            if(board[i][n-1] == 'O')
                DFS(board, i, n-1, m, n);
        }

        // Checking the first and last columns..
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O')
                DFS(board, 0, j, m, n);
            if(board[m-1][j] == 'O')
                DFS(board, m-1, j, m, n);
        }

        // Checking the first and last Rows..
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    private void DFS(char[][] board, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || board[i][j] != 'O') return;

        board[i][j] = '#';

        DFS(board, i-1, j, m, n);
        DFS(board, i+1, j, m, n);
        DFS(board, i, j-1, m, n);
        DFS(board, i, j+1, m, n);
    }
}