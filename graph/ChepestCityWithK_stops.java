import java.util.*;


public class ChepestCityWithK_stops {

    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
             this.wt=w;

        }

    }

    public static class info{
        int v;
        int cost;
        int stops;
        public info( int v,int c,int s){
                this.v=v;
                this.cost=c;
                this.stops=s;
        }
         

    }

    public static  void CreteGraph(ArrayList<Edge>graph[],int flights[][]){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        
        
        }

        for( int i=0;i<flights.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int cost=flights[i][2];
            Edge e=new Edge(src, dest, cost);
            graph[src].add(e);
        }
    }


    public  static int ChepestCity(ArrayList<Edge>graph[],int flights[][],int src,int dest,int k,int v){

        int dist[]=new int[v];
        for(int i=0 ;i<graph.length;i++){


            if(i!=src){
                 dist[i]=Integer.MAX_VALUE;
            }
           
        }
        Queue<info> q = new LinkedList<>();
        q.add(new info(src, 0, 0));

        while ((!q.isEmpty())) {
            info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e=graph[curr.v].get(i);
                int u=e.src;

                int b=e.dest;
                int wt=e.wt;

                // if(dist[u]!=Integer.MAX_VALUE&& (dist[u]+wt)<dist[b]&&curr.stops<=k){
                //     dist[b]=dist[u]+wt;
                //     q.add(new info(b,dist[b], curr.stops+1));

                // }

                
                if(dist[u]!=Integer.MAX_VALUE&& (curr.cost+wt)<dist[b]&&curr.stops<=k){
                    dist[b]=curr.cost+wt;
                    q.add(new info(b,dist[b], curr.stops+1));

                }


            }
            
        }if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        } else{
             return dist[dest];
            }

    }
    public static void main(String[] args) {
        int v=3;

        int flights[][]={{0,1,100},
                            {1,2,100},
                            {0,2,500}};
        @SuppressWarnings("unchecked")
        ArrayList<Edge>graph []=new ArrayList[3] ;   
        CreteGraph(graph, flights);

        System.out.println( ChepestCity(graph, flights, 0, 2, 1, v));

       ;

        
                        
        
    }
    
}
