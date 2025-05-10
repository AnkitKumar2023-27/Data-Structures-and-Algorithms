import java.util.ArrayList;


public class dfs {


    public static class Eadge {
        int src;
        int dest;
        int wt;

        public Eadge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void dfs(ArrayList<Eadge> graph[], int curr, boolean vis[]) {

        vis[curr] = true; // Mark the current node as visited
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Eadge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {

        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge> graph[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Eadge(0, 1, 5));
        graph[0].add(new Eadge(0, 2, 3));

        graph[1].add(new Eadge(1, 3, 5));
        graph[1].add(new Eadge(1, 0, 5));

        graph[2].add(new Eadge(2, 4, 2));
        graph[2].add(new Eadge(2, 0, 3));

        graph[3].add(new Eadge(3, 5, 1));
        graph[3].add(new Eadge(3, 1, 1));

        graph[4].add(new Eadge(4, 5, 3));
        graph[4].add(new Eadge(4, 2, 3));

        graph[5].add(new Eadge(5, 6, 3));
        graph[5].add(new Eadge(5, 3, 3));
        graph[5].add(new Eadge(5, 4, 3));

        graph[6].add(new Eadge(6, 5, 3));
        boolean vis[] = new boolean[graph.length];

        dfs(graph, 0, vis);
        System.out.println(); // Add a newline for better formatting
    }
}