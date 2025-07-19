import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KansAlgorithm {

    public static class Edge{
        int src;
        int dest;
        
        public Edge(int src,int dest){
            this.src=src;
             this.dest=dest;

        }
    }


    public static void calDeg(ArrayList<Edge>graph[],int indeg[]){
            for ( int i=0;i<graph.length;i++){
                int v=i;
                for(int j=0;j<graph[v].size();j++){
                    Edge e= graph[v].get(j);
                    indeg[e.dest]++;
                }

            }
    }
    public static void KansAlgo(ArrayList<Edge>graph[]){
        Queue<Integer>q=new LinkedList<>();
         int Indeg[]=new int[graph.length];
         calDeg(graph, Indeg);

          for ( int i=0;i<Indeg.length;i++){
            if(Indeg[i]==0){
                q.add(i);
            }
          }

           while(!q.isEmpty()){
            int curr= q.remove();
             System.out.print(curr+" ");
             for( int i=0;i< graph[curr].size();i++){
                 Edge e=graph[curr].get(i);
               Indeg[e.dest]--;
               if(Indeg[e.dest]==0){
                q.add(e.dest);
               }

             }
           }
             System.out.println();
    }

    
    public static void main(String[] args) {
        int v=6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] =new  ArrayList[v];
         for ( int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
         }
       
    graph[2].add(new Edge(2,3));
    graph[3].add(new Edge(3,1));
    graph[4].add(new Edge(4,0));
    graph[4].add(new Edge(4,1));
    graph[5].add(new Edge(5,0));
    graph[5].add(new Edge(5,2));
         
       
      

        KansAlgo( graph);

        
        
    }
}
