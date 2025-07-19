import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {


      public static class Edge{
        int src;
        int dest;
        int wt;
      public Edge(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;

        }
        

    }

    public static  class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public  Pair( int n, int c){
            this .v=n;
            this.cost=c;

        }
           
@Override
public int compareTo(Pair p2){
     return this .cost-p2.cost;
}

    }


public static void Prims(ArrayList<Edge>graph[]){

    boolean vis[]=new boolean[graph.length];
    PriorityQueue<Pair>pq=new PriorityQueue<>();
    pq.add(new Pair(0, 0));

    int finalCost=0;
    while (!pq.isEmpty()) {
        Pair curr=pq.remove();
        if(!vis[curr.v]){
            vis[curr.v]=true;
            finalCost+=curr.cost;

            for(int i=0;i<graph[curr.v].size();i++){
                Edge e =graph[curr.v].get(i);
                pq.add(new Pair(e.dest, e.wt));
            }

        }
        
    }

    System.out.println(finalCost);


}

public static void main(String[] args) {
    
        
       int v=6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] =new  ArrayList[v];
         for ( int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
         }
       
    graph[0].add(new Edge(0,1,10));
    graph[0].add(new Edge(0,2,15));
    graph[1].add(new Edge(0,3,30));
    graph[1].add(new Edge(1,0,10));
    graph[2].add(new Edge(1,3,40));
    graph[3].add(new Edge(2,3,50));
    graph[4].add(new Edge(3,1,40));
    graph[4].add(new Edge(3,2,50));

   
    Prims(graph);

    }
    

    
}
