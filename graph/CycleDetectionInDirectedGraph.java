import java.util.ArrayList;




public class  CycleDetectionInDirectedGraph{

    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean IsCycle(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]= new boolean[graph.length];
        for( int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(IsCycleutil(graph,i,vis,stack)) {
                    return true;
                }
                
            }
        }
        return false;
    }
  public static boolean IsCycleutil(ArrayList<Edge>graph[],int curr,boolean vis[],boolean stack[]){

    vis[curr]=true;
    stack[curr]=true;
    for( int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);
        if (stack[curr]) {
            return true;
            
        }
        if(vis[e.dest ] && IsCycleutil(graph,e.dest,vis,stack)){
            return true;
        }

    }
    stack[curr]=false;
    return false;

  }
    public static void main(String[] args) {
        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 2));

        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

        graph[6].add(new Edge(6, 5));

        // You can now implement directed graph algorithms on this representation,
        // such as finding paths, topological sort (if it's a DAG), etc.

        // // For example, let's just print the adjacency list:
        // for (int i = 0; i < v; i++) {
        //     System.out.print("Adjacency list of vertex " + i + ": ");
        //     for (Edge edge : graph[i]) {
        //         System.out.print("(" + edge.dest + ") ");
        //     }
        //     System.out.println();
        // }

     System.out.println( IsCycle(graph));  
    }
}
