class Solution {
    public void solve(char[][] board) {

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }
        }

        for (int i = 1; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
        }

        for (int j = 1; j < board[0].length; j++) {
            if (board[board.length - 1][j] == 'O') {
                dfs(board.length - 1, j, board);
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][board[0].length - 1] == 'O') {
                dfs(i, board[0].length - 1, board);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(int row, int col, char[][] board) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '-';

        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row + 1, col, board);
        dfs(row, col - 1, board);
    }
}