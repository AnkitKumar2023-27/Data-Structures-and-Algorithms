

public class OneThreeZero {

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];

        // top & bottom row
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && board[0][j] == 'O') {
                dfs(board, 0, j, vis);
            }
            if (!vis[n - 1][j] && board[n - 1][j] == 'O') {
                dfs(board, n - 1, j, vis);
            }
        }

        // left & right column
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(board, i, 0, vis);
            }
            if (!vis[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(board, i, m - 1, vis);
            }
        }

        // flip internal O’s not connected to boundary
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int col, boolean[][] vis) {
        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;
        int r1[] = {1, 0, -1, 0};
        int c1[] = {0, -1, 0, 1};

        for (int k = 0; k < 4; k++) {
            int nrow = row + r1[k];
            int ncol = col + c1[k];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                !vis[nrow][ncol] && board[nrow][ncol] == 'O') {
                dfs(board, nrow, ncol, vis);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };

        solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
