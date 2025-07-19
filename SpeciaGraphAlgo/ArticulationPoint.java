import java.util.ArrayList;

public class ArticulationPoint{

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
        graph[4].add(new Edge(4,3));
    }


    public static void dfs(ArrayList<Edge>graph[],int curr,int par,int dt[],int low[],boolean vis[],int time,int children,boolean ap[]){
          vis[curr]=true;
          dt[curr]=low[curr]=++time;


          for( int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            int nighb=e.dest;
            if( par==nighb){
                continue;

            }else if(vis[nighb]){
                low[curr]=Math.min(low[curr],dt[nighb]);
            }else{
                dfs(graph, nighb, par, dt, low, vis, time, children,ap);
               low[curr]=Math.min(low[curr], low[nighb]);
               if(par!=-1 && dt[curr]<=low[nighb]){
                ap[curr]=true;
               }  
                children++;
            }
         
            
          }
          if(par==-1&&children>1){
            ap[curr]=true;   
          }

    }


    public static void AP(ArrayList<Edge>graph[],int v){
        boolean vis[]=new boolean[v];
        int par=-1;
        boolean ap[]=new boolean[v] ;
        int dt[]=new int[v];
        int low[]=new int[v];
        int time=0;
        int children=0;

        for(int i=0;i<graph.length;i++){
    
         if(!vis[i]){
           dfs(graph, i, par, dt, low,vis, time, children,ap);
         }
        }

        for( int i=0;i<v;i++){
            if(ap[i]){
                System.out.println("AP is --> " + i);

            }
        }
    }



    public static void main(String[] args) {

        int v=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>graph[]=new ArrayList[v];

        Creategraph(graph, v);
        AP(graph,v);
        


    }
}