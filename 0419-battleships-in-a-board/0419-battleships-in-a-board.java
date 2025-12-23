class Solution {
    private void DFS(char[][] board, int i, int j){
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || board[i][j] == '.') return;

        board[i][j] = '.'; // Mark it as visited cell..

        DFS(board, i-1, j);
        DFS(board, i+1, j);
        DFS(board, i, j-1);
        DFS(board, i, j+1);
    }
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X'){
                    DFS(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}