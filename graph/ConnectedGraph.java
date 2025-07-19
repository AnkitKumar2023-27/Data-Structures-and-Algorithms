import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class  ConnectedGraph {


   

    public static class Eadge{
        int src;
        int dest;
        int wt;
      public Eadge(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;

        }
        

    }

     public static void bfs(ArrayList<Eadge>graph[]){
        boolean visit[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            bfsUtil(graph,visit);
            
        }

     }

    public static void bfsUtil(ArrayList<Eadge>graph[],boolean vis[]){

        Queue<Integer>q=new LinkedList<>();
       
        q.add(0);

        while (!q.isEmpty()) {

            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;

                for(int i=0;i<graph[curr].size();i++){
                   Eadge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
            
        }


    }


    public static void  dfs (ArrayList<Eadge>graph[]){
    boolean vis[]=new boolean[graph.length];

    for(int i=0;i<graph.length;i++){
        dfsUtil(graph, i,vis);

    }
}
    

        public static void dfsUtil(ArrayList<Eadge> graph[], int curr, boolean vis[]) {

        vis[curr] = true; // Mark the current node as visited
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Eadge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {

            int v=7;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++){

            graph[i]=new ArrayList<>();
        }
     
             graph[0].add(new Eadge(0,1,5));
            graph[0].add(new Eadge(0,2,3));

            graph[1].add(new Eadge(1,3,5));
            graph[1].add(new Eadge(1,0,5));
            
            graph[2].add(new Eadge(2,4,2));
            graph[2].add(new Eadge(2,0,3));
       

        graph[3].add(new Eadge(3,5,1));
        graph[3].add(new Eadge(3,1,1));

        graph[4].add(new Eadge(4,5,3));
        graph[4].add(new Eadge(4,2,3));


         graph[5].add(new Eadge(5,6,3));
         graph[5].add(new Eadge(5,3,3));
         graph[5].add(new Eadge(5,4,3));


        
        graph[6].add(new Eadge(6,5,3));

      bfs(graph);

      System.out.println();
         dfs(graph);
        
      
       

        
    }
    
}
