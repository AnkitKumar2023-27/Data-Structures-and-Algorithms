import java.util.ArrayList;
import java.util.Collections;

public class MazeProblem {

    public static void MazeRun(
        int maze[][], int mazeAns[][], int x, int y, int n, String ans, ArrayList<String> paths) {

        // Base case: If the end of the maze is reached
        if (x == n - 1 && y == n - 1) {
            paths.add(ans);
            mazeAns[x][y] = 1; // Mark the last cell
            System.out.println("One solution:");
            PrintMaze(mazeAns); // Print the maze solution
            mazeAns[x][y] = 0; // Reset the last cell after printing
            return;
        }

        // Mark the current cell as part of the path
        mazeAns[x][y] = 1;

        // Explore in lexicographical order: Down, Left, Right, Up

        // Down
        if (IsSafe(x + 1, y, maze, mazeAns, n)) {
            MazeRun(maze, mazeAns, x + 1, y, n, ans + "D", paths);
        }

        // Left
        if (IsSafe(x, y - 1, maze, mazeAns, n)) {
            MazeRun(maze, mazeAns, x, y - 1, n, ans + "L", paths);
        }

        // Right
        if (IsSafe(x, y + 1, maze, mazeAns, n)) {
            MazeRun(maze, mazeAns, x, y + 1, n, ans + "R", paths);
        }

        // Up
        if (IsSafe(x - 1, y, maze, mazeAns, n)) {
            MazeRun(maze, mazeAns, x - 1, y, n, ans + "U", paths);
        }

        // Backtrack: Unmark the cell
        mazeAns[x][y] = 0;
    }

    public static boolean IsSafe(int newX, int newY, int maze[][], int mazeAns[][], int n) {
        return (newX >= 0 && newX < n && newY >= 0 && newY < n &&
                maze[newX][newY] == 1 && mazeAns[newX][newY] == 0);
    }

    public static void PrintMaze(int maze[][]) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        int mazeAns[][] = new int[maze.length][maze.length];
        ArrayList<String> paths = new ArrayList<>();

        System.out.println("Original Maze:");
        PrintMaze(maze);

        MazeRun(maze, mazeAns, 0, 0, maze.length, "", paths);

        if (paths.isEmpty()) {
            System.out.println("No solution exists for this maze.");
        } else {
            // Sort the paths lexicographically
            Collections.sort(paths);

            System.out.println("Solutions in lexicographical order:");
            for (String path : paths) {
                System.out.println(path);
            }
        }
    }
}
