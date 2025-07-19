import java.util.ArrayList;

public class BellManFord {

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


    

    public static void  BellManFordAlgo(ArrayList<Edge>graph[],int src){
        int dis[]=new int[graph.length];
        for( int i=0; i<graph.length;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        for( int i =0;i<V-1;i++){
            for( int j=0; j<graph.length;j++){
                for( int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt; 

                    if(dis[u]!=Integer.MAX_VALUE&& (dis[u]+wt)<dis[v]){
                        dis[v]=dis[u]+wt;


                    }
                }
            }
        }

        for( int i=0;i<dis.length;i++){
             System.out.println(" Smalles Distence From Src to " +i +" is -->> "+dis[i]);
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

    int src=0;
         BellManFordAlgo(graph,src);
        
    }
    
}
