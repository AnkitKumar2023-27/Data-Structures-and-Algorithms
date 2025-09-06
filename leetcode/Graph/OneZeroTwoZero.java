public class OneZeroTwoZero {

     public static int  numEnclaves(int[][] grid) {
       
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];

        // top & bottom row
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && grid[0][j] == 1) {
                dfs(grid, 0, j, vis);
            }
            if (!vis[n - 1][j] && grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j, vis);
            }
        }

        // left & right column
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && grid[i][0] == 'O') {
                dfs(grid, i, 0, vis);
            }
            if (!vis[i][m - 1] && grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1, vis);
            }
        }
       int count=0;
        // flip internal O’s not connected to boundary
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                   vis[i][j]=true;
                   count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] board, int row, int col, boolean[][] vis) {
        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;
        int r1[] = {1, 0, -1, 0};
        int c1[] = {0, -1, 0, 1};

        for (int k = 0; k < 4; k++) {
            int nrow = row + r1[k];
            int ncol = col + c1[k];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                !vis[nrow][ncol] && board[nrow][ncol] == 1) {
                dfs(board, nrow, ncol, vis);
            }
        }
    }
        
    
    public static void main(String[] args) {
        int[][] grid = {
    {0, 0, 0, 0},
    {1, 0, 1, 0},
    {0, 1, 1, 0},
    {0, 0, 0, 0}
};
System.out.println(numEnclaves(grid));
        
    }
    
}
