import java.util.ArrayList;

public class BridgeInGraph{

    public static class Edge{
      int src;
       int dest;
       public Edge( int s, int d){
         this.src=s;
          this.dest=d;
       }
         
    }
    public static void Creategraph( ArrayList<Edge>graph[],int v){

          for ( int i =0;i< graph.length;i++){
            graph[i]=new ArrayList<>();

          }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
         graph[3].add(new Edge(3,5));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
    }


    public static void TarjanAlgo(ArrayList<Edge>graph[],int curr,int par,int dt[],int low[],boolean vis[],int time){
          vis[curr]=true;
          dt[curr]=low[curr]=++time;


          for( int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            int nighb=e.dest;
            if( par==nighb){
                continue;

            }else if(!vis[nighb]){
                TarjanAlgo(graph, nighb,curr, dt, low, vis, time);
               low[curr]=Math.min(low[curr],low[nighb]);
               if( dt[curr]<low[nighb]){
                System.out.print("BRIDGE IS   "+curr+" ----"+nighb);
                
               }  
             
               
            }else{
                low[curr]=Math.min(low[curr],dt[nighb]);
            }
  
            
          }
          
          }

    


    public static void BridgeInGrap(ArrayList<Edge>graph[],int v){
        boolean vis[]=new boolean[v];
        int par=-1;
       
        int dt[]=new int[v];
        int low[]=new int[v];
       int  time=0;
 
       

        for(int i=0;i<graph.length;i++){
    
         if(!vis[i]){
           TarjanAlgo(graph, i, par, dt, low, vis, time);
         }
        }

    }



    public static void main(String[] args) {

        int v=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>graph[]=new ArrayList[v];

        Creategraph(graph, v);
       BridgeInGrap(graph, v);
        


    }
}