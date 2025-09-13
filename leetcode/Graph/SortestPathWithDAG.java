import java.util.ArrayList;
import java.util.Stack;

public class SortestPathWithDAG {
    public static class Eadge {
        int src, dest, wt;
        public Eadge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void SortestDis(ArrayList<Eadge> graph[]) {
        int n = graph.length;
        int dis[] = new int[n];
        boolean vis[] = new boolean[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                toposort(i, graph, vis, s);
            }
        }

        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[6] = 0; // source = 6 (as per diagram)

        while (!s.isEmpty()) {
            int curr = s.pop();
            if (dis[curr] != Integer.MAX_VALUE) {
                for (int i = 0; i < graph[curr].size(); i++) {
                    Eadge e = graph[curr].get(i);
                    int dest = e.dest;
                    int wt = e.wt;
                    if (dis[curr] + wt < dis[dest]) {
                        dis[dest] = dis[curr] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Shortest distance from 6 to " + i + " = " + dis[i]);
        }
    }

    public static void toposort(int curr, ArrayList<Eadge> graph[], boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Eadge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                toposort(e.dest, graph, vis, s);
            }
        }
        s.push(curr);
    }

    // ✅ Graph creation based on the image
    public static void graphcreation(ArrayList<Eadge> graph[], int n) {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[4].add(new Eadge(4, 0, 3));
        graph[0].add(new Eadge(0, 1, 2));
        graph[1].add(new Eadge(1, 3, 1));
        graph[2].add(new Eadge(2, 3, 3));
        graph[4].add(new Eadge(4, 2, 1));
        graph[6].add(new Eadge(6, 4, 2));
        graph[6].add(new Eadge(6, 5, 3));
        graph[5].add(new Eadge(5, 4, 1));
    }

    public static void main(String[] args) {
        int n = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge> graph[] = new ArrayList[n];
        graphcreation(graph, n);

        SortestDis(graph);
    }
}
