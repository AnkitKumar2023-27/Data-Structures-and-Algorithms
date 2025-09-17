import java.util.ArrayList;
import java.util.PriorityQueue;



public class MST {
    public static class Info{
        int src ; int dest; 
         int wt;
         public Info( int s, int d, int w){
             this.src=s;
              this.dest=d;
              this. wt=w;
         }
         
    }
     public static class pair implements Comparable<pair> {
        int node;
        int wt;
        public pair(int n, int wt){
            this.node=n;
             this.wt=wt;
        }
     public int compareTo(pair p){
        return this.wt-p.wt;
     }
        
     } 

     public static void graphCreation(ArrayList<Info>graph[], int n){
        for( int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Info(0, 1,10));
        graph[0].add(new Info(0, 2,15));
        graph[0].add(new Info(0,3,30));
        graph[1].add(new Info( 1,0,10));
        graph[1].add(new Info(1, 3,40));
        graph[2].add(new Info(2, 0,15));
        graph[2].add(new Info(2, 3,50));
        graph[3].add(new Info(3, 1,40));
        graph[3].add(new Info(3, 2,50));
     }

public  static int mst(ArrayList<Info>graph[]){
       boolean vis[]=new boolean[graph.length];
       PriorityQueue<pair>pq=new PriorityQueue<>();
       pq.add(new pair(0, 0));
       int mst=0;
       while (!pq.isEmpty()) {
         pair p=pq.remove();
         int curr=p.node;
          int wt=p.wt;
          
          if(!vis[curr]){
            vis[curr]=true;
            mst+=wt;
            for(int i=0;i<graph[curr].size();i++){
                Info e=graph[curr].get(i);
                int dest =e.dest;
                int w=e.wt;
                pq.add(new pair(dest,w));

            }
          }
       }
       return mst;
}
public static void main(String[] args) {
    int v=4;
    @SuppressWarnings("unchecked")
    ArrayList<Info>graph[]=new ArrayList[9];
    graphCreation(graph, v);
    System.out.println(mst(graph));
}
    
}
