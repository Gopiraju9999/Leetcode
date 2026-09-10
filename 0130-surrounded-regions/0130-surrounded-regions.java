class Solution {
    public void solve(char[][] board) {
        int m = board.length;    // "m" for columns
        int n = board[0].length; // "n" for rows
        
        // Our aim is to make cells as "X" except boundary 0's
        // Check boundaries has "0" and also make connected cells with "0" as "X"
        // Initially, boundary "0" convert it into "#". 
        // Then, through out matrix i,j == 0 convert into "X" & "#" convert into "0"

        // Check the first & last columns
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                DFS(board, i, 0, m, n);
            }
            if(board[i][n-1] == 'O'){
                DFS(board, i, n-1, m, n);
            }
        }

        // Check the first & last rows
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O'){
                DFS(board, 0, j, m, n);
            }
            if(board[m-1][j] == 'O'){
                DFS(board, m-1, j, m, n);
            }
        }
        
        // Original matrix for making changes in it..
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
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;

        // Means, it's a boundary "o" cell mark it as "#"
        board[i][j] = '#'; 

        // Calling DFS calls for 4 possible moves (up, down, left, right)
        DFS(board, i-1, j, m, n);
        DFS(board, i+1, j, m, n);
        DFS(board, i, j-1, m, n);
        DFS(board, i, j+1, m, n);
    }
}