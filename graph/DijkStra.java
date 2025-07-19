import java.util.ArrayList;
import java.util.PriorityQueue;



public class DijkStra {
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
        int node;
        int path;
        public  Pair( int n, int p){
            this .node=n;
            this.path =p;

        }
           
@Override
public int compareTo(Pair p2){
     return this .path-p2.path;
}

    }

public static void DijkastraAlgo(ArrayList<Edge>graph[],int s){

    int   dis[]=new int [graph.length];
     for( int i =0; i<graph.length;i++){
         if(i!=s){
             dis[i]=Integer.MAX_VALUE;
         }
     }

     dis[s]=0;

     PriorityQueue<Pair>pq=new PriorityQueue<>();
   
     boolean vis[]= new boolean[graph.length];
       pq.add(new Pair(s, 0));

       while(!pq.isEmpty()){
        Pair curr=pq.remove();
        if(!vis[curr.node]){
            vis[curr.node]=true;
            for( int i=0;i<graph[curr.node].size();i++){
                  Edge  e=graph[curr.node].get(i);
                   int u= e.src;
                   int v=e.dest;
                    int w=e.wt;

                    if((dis[u]+w)<dis[v]){
                        dis[v]=dis[u]+w;
                        pq.add(new Pair(v,dis[v]));
                    }

            }
        }
       }

       for( int i=0;i<dis.length;i++){
         System.out.println( "Smallest dist from src to  "+i+"-->> " +dis[i]);
       }

     

}
    
        
    

public static void main(String[] args) {

       int v=6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] =new  ArrayList[v];
         for ( int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
         }
       
    graph[0].add(new Edge(0,1,2));
    graph[0].add(new Edge(0,2,4));
    graph[1].add(new Edge(1,3,7));
    graph[1].add(new Edge(1,2,1));
    graph[2].add(new Edge(2,4,3));
    graph[3].add(new Edge(3,5,1));
    graph[4].add(new Edge(4,3,2));
    graph[4].add(new Edge(4,5,5));
         
        int Source=0;
         DijkastraAlgo(graph,Source);
      
    
}

    
}
