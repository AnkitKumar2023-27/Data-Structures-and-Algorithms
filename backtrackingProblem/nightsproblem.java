package backtrackingProblem;
public class nightsproblem {

    private static final int N = 8; // Board size (N x N)
    private static int[][] board = new int[N][N];
    private static int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1; // Initialize board with -1 (unvisited)
            }
        }

        // Start from (0, 0)
        board[0][0] = 0; 
        if (solveKnightTour(0, 0, 1)) {
            printSolution();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean solveKnightTour(int x, int y, int moveCount) {
        if (moveCount == N * N) {
            return true; // All squares visited
        }

        for (int i = 0; i < 8; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];

            if (isSafe(nextX, nextY)) {
                board[nextX][nextY] = moveCount; 
                if (solveKnightTour(nextX, nextY, moveCount + 1)) {
                    return true;
                }
                board[nextX][nextY] = -1; // Backtrack
            }
        }

        return false; // No solution found from current position
    }

    private static boolean isSafe(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1;
    }

    private static void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}