import java.util.ArrayList;

public class FiveFourSeven {
    public static class Eadge {
        int src, dest;
        public Eadge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    @SuppressWarnings("unchecked")
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

       
        ArrayList<Eadge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    graph[i].add(new Eadge(i, j));
                }
            }
        }

      // Step 3: DFS to count connected components
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis);
                count++;
            }
        }
        return count;
    }

    public static void dfs(ArrayList<Eadge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        for (Eadge e : graph[curr]) {
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

// another logic when we dont need to create a graph///////////////////////////////????????????????????????

    // public int findCircleNum(int[][] isConnected) {
    //     int c=0;
    //     int n=isConnected.length;
    //     boolean vis[]=new boolean[n];

    //     for(int i=0; i<n; i++)
    //     {
    //         if(vis[i]==false)
    //         {
    //             c++;
    //             dfs(vis,i,isConnected);
                
    //         }
    //     }
    //     return c;

    // }
    // public void dfs(boolean vis[], int i, int[][] adj)
    // {
    //     vis[i]=true;
    //     for(int child=0; child < adj.length; child ++)
    //     {
    //         if(adj[i][child]==1 && adj[i]!=adj[child])
    //         {
    //             if(vis[child]==false)
    //             dfs(vis,child,adj);
    //         }
    //     }
    // } 

    // Test
    public static void main(String[] args) {
        FiveFourSeven obj = new FiveFourSeven();
        int isConnected[][] = {
        
    {1, 1, 0, 0, 0},
    {0, 1, 0, 0, 1},
    {1, 0, 0, 1, 1},
    {0, 0, 0, 0, 0},
    {1, 0, 1, 1, 0}
};

    
        System.out.println(obj.findCircleNum(isConnected)); // Output: 2
    }
}
