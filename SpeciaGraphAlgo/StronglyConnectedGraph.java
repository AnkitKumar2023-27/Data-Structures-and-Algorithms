import java.util.*;
//----------------------------------------  KOSARAJU   ALGORITHM   ------------
public class StronglyConnectedGraph {

    public static class Edge {
        int src;
         int dest;
         public Edge(int s,int d){
            this.src=s;
            this.dest=d;
            
            

         }     
          
    }


    public static void topSort(ArrayList<Edge>graph[],int curr,boolean vis[],Stack<Integer> s){
        vis[curr]=true;
   
         for( int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph,e.dest, vis, s);
            }
         }
         s.push(curr);
    }

    public static void dfs(ArrayList<Edge>graph[],int curr,boolean vis[]){
         vis[curr]=true;
          System.out.print(curr +" ");
         for( int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){

                
                dfs(graph,e.dest, vis);

              
            }
             
         }
          System.out.println();
         

    }


  public static void kosaraju(ArrayList<Edge   >graph[],int v) {
    Stack<Integer>s=new Stack<>();     

    boolean vis[]=new boolean[v];
        for( int i=0;i<graph.length;i++){
            if(!vis[i]){
                  topSort(graph,i,vis,s);
            }
          
        }
   @SuppressWarnings("unchecked")
   ArrayList<Edge>Transpose[]=new ArrayList[v];
   for(int i=0;i<v;i++){
    vis[i]=false;
     Transpose[i]=new ArrayList<>();
   }
   for( int j=0;j<graph.length;j++){
    for(int i=0;i<graph[j].size();i++){
        Edge e=graph[j].get(i);
        Transpose[e.dest].add(new Edge(e.dest, e.src));

    }

   }

     while (!s.isEmpty()) {
        int curr=s.pop();
        if(!vis[curr]){
            dfs(Transpose,curr,vis);
        }
     }


  }

  
    public static void Creategraph(ArrayList<Edge>graph[],int v){
        for( int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
            


        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
    
    }
  

    

    public static void main(String[] args) {

        int v=5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>graph[]=new ArrayList[v];
       Creategraph(graph, v);

       kosaraju(graph, v);
       
    }
    
}
