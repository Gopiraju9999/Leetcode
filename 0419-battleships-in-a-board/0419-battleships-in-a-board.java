class Solution {
    private void DFS(char[][] board, int i, int j, int m, int n){
        if(i<0 || i>= m || j<0 || j>=n || board[i][j] == '.') return;

        board[i][j] = '.'; // Mark it as visited cell..

        DFS(board, i-1, j, m, n);
        DFS(board, i+1, j, m, n);
        DFS(board, i, j-1, m, n);
        DFS(board, i, j+1, m, n);
    }
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X'){
                    DFS(board, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
}