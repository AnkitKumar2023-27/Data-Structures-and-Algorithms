import java.util.*;

public class EightZerotwo {
    public static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<Edge>[] reverseGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            reverseGraph[i] = new ArrayList<>();
        }

        // build reverse graph using normal for loop
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int nei = graph[i][j];
                reverseGraph[nei].add(new Edge(nei, i));
            }
        }

        return topoSort(reverseGraph);
    }

    public static List<Integer> topoSort(ArrayList<Edge>[] graph) {
        int n = graph.length;
        int indegree[] = new int[n];
        Queue<Integer> q = new LinkedList<>();

        calcIndegree(graph, indegree);
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> safe = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            safe.add(curr);
            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) q.add(e.dest);
            }
        }

        Collections.sort(safe);
        return safe;
    }

    public static void calcIndegree(ArrayList<Edge>[] graph, int indegree[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }
}
