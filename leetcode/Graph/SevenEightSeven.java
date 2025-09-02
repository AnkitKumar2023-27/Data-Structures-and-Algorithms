import java.util.ArrayList;
import java.util.PriorityQueue;

public class SevenEightSeven {

    public static class  eadge {
        int src; 
        int dest;
        int wt;
        public eadge( int s,int d , int w ){
            this.src=s;
             this.dest=d;
              this.wt=w;

        }
      
        
    }
    public static class  info implements  Comparable<info> {
        int v; 
        int cost;
         int stops;
         public info(int v, int c, int s){
            this.v=v;
            this.cost=c;
            this.stops=s;
         }
  @Override
    public int compareTo(info other){
     return this.cost - other.cost;
    }
        
    }

    public static  int price(ArrayList<eadge>graph[], int src, int  dst, int k ){
        // boolean vis[]= new boolean[graph.length];
        int dis[]=new int[graph.length];
        for( int i=0;i<graph.length;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        } 
        PriorityQueue<info>pq=new PriorityQueue<>();
        pq.add(new info(src, 0, 0));
        while (!pq.isEmpty()) {
            info curr=pq.remove();
            if(curr.stops>k){
              continue;
            }

            // if(!vis[curr.v]){
            //     vis[curr.v]=true;
            //     for( int i=0;i<graph[curr.v].size();i++){
            //         eadge e=graph[curr.v].get(i);
            //         int u=e.src;
            //         int v=e.dest;
            //         int wt=e.wt;

            //         if(curr.cost+wt<dis[v]&&curr.stops<=k){
            //             dis[v]=curr.cost+wt;
            //              pq.add(new info(v, dis[v], curr.stops + 1));
            //         }
            //     }
            // }/
            for (int i = 0; i < graph[curr.v].size(); i++) {
    eadge e = graph[curr.v].get(i);
    int u = e.src;
    int v = e.dest;
    int wt = e.wt;

    if (curr.cost + wt < dis[v] && curr.stops <= k) {
        dis[v] = curr.cost + wt;
        pq.add(new info(v, dis[v], curr.stops + 1));
    }
}

            
        }
        if(dis[dst]==Integer.MAX_VALUE){
            return-1;

        }else{
            return dis[dst];
        }

    }

       @SuppressWarnings("unchecked")
    public  static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
          ArrayList<eadge>graph[]= new ArrayList[n];
          for( int i=0; i<n;i++){
               graph[i]=new ArrayList<>();
          }
          for( int i=0;i<flights.length;i++){
            int  Src=flights[i][0];
            int dest=flights[i][1];
            int cost=flights[i][2];
            eadge e=new eadge(Src, dest, cost);
            graph[Src].add(e);

          }
           
        return price(graph, src, dst,k);

        
    }






    public static void main(String[] args) {
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int n=4;
       int  src = 0;
       int dst = 3;
       int k = 1;
       System.out.println(findCheapestPrice(n, flights, src, dst, k));


        
    }
}