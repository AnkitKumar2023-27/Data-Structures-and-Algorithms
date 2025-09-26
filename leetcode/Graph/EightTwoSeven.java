import java.util.HashSet;

public class EightTwoSeven {
    public static class DisJointSet {
        static int parent[];
        static int size[];
        DisJointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public static int find(int n) {
            if (n == parent[n]) return n;
            return parent[n] = find(parent[n]);
        }
        public static void union(int a, int b) {
            int parA = find(a);
            int parB = find(b);
            if (parA == parB) return;
            if (size[parA] < size[parB]) {
                parent[parA] = parB;
                size[parB] += size[parA];
            } else {
                parent[parB] = parA;
                size[parA] += size[parB];
            }
        }
    }

    private static boolean isValid(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        DisJointSet ds = new DisJointSet(n * n);

      
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};
                for (int k = 0; k < 4; k++) {
                    int newR = i + dr[k];
                    int newC = j + dc[k];
                    if (isValid(newR, newC, n) && grid[newR][newC] == 1) {
                        int node = i * n + j;
                        int newNode = newR * n + newC;
                        ds.union(node, newNode);
                    }
                }
            }
        }

        int max = 0;

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;

                HashSet<Integer> Component = new HashSet<>();
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};

                for (int k = 0; k < 4; k++) {
                    int newR = i + dr[k];
                    int newC = j + dc[k];
                    if (isValid(newR, newC, n) && grid[newR][newC] == 1) {
                        int newNode = newR * n + newC;
                        Component.add(DisJointSet.find(newNode));
                    }
                }

                int size = 1; 
                for (Integer it : Component) {
                    size += DisJointSet.size[it];
                }
                max = Math.max(max, size);
            }
        }

      
        for (int i = 0; i < n * n; i++) {
            if (DisJointSet.find(i) == i) {
                max = Math.max(max, DisJointSet.size[i]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 1}};
        System.out.println(largestIsland(grid)); // Expected 3
    }
}
