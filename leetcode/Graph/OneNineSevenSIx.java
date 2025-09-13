import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class OneNineSevenSIx {
    public static class Eadge {
        int src, dest, time;
        public Eadge(int s, int d, int t) {
            this.src = s;
            this.dest = d;
            this.time = t;
        }
    }

    public static class pair implements Comparable<pair> {
        int dest;
        int steps;
        public pair(int d, int s) {
            this.dest = d;
            this.steps = s;
        }
        public int compareTo(pair p) {
            return this.steps - p.steps;
        }
    }

    @SuppressWarnings("unchecked")
    public static int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        // Build graph
        ArrayList<Eadge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {  
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            graph[u].add(new Eadge(u, v, w));
            graph[v].add(new Eadge(v, u, w)); 
        }

        // Dijkstra
        int[] dis = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(ways, 0);

        dis[0] = 0;
        ways[0] = 1;

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0));

        while (!pq.isEmpty()) {
            pair p = pq.remove();
            int curr = p.dest;
            int d = p.steps;

            if (d > dis[curr]) continue; 

            for (int i = 0; i < graph[curr].size(); i++) {
                Eadge e = graph[curr].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.time;

                if (dis[u] + wt < dis[v]) {
                    dis[v] = dis[u] + wt;
                    ways[v] = ways[u];
                    pq.add(new pair(v, dis[v]));
                } else if (dis[u] + wt == dis[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[n - 1] % MOD;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
            {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3},
            {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1},
            {0, 4, 5}, {4, 6, 2}
        };
        System.out.println(countPaths(n, roads));
    }
}
