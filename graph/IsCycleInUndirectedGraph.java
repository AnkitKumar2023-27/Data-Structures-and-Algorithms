import java.util.ArrayList;

public class IsCycleInUndirectedGraph{

    public static class Eadge{
        int src;
        int dest;
       
      public Eadge(int src,int dest){
        this.src=src;
        this.dest=dest;
      
        }
        

    }
  public static boolean IsCycle(ArrayList<Eadge>graph[]){

    boolean vis[]=new boolean[graph.length];
    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
          
          if ( IsCycleUtil(graph,vis,i,-1)) {
            return true;
            
          } 
        
        } 
    } return false;
  }

  public static boolean IsCycleUtil(ArrayList<Eadge>graph[],boolean vis[],int curr,int par){

    vis[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
        Eadge e=graph[curr].get(i);
        if(!vis[e.dest]){
           if(IsCycleUtil(graph,vis,e.dest,curr)){
            return true;
           }
        }
        if(vis[e.dest]&&e.dest!=par){
            return true;
        }
    }
    return false;

  }


    public static void main(String[] args) {

            int v=7;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++){

            graph[i]=new ArrayList<>();
        }
     
        graph[0].add(new Eadge(0,1));
        
         graph[0].add(new Eadge(0,3));

        graph[1].add(new Eadge(1,2));
        graph[1].add(new Eadge(1,0));
        
        graph[2].add(new Eadge(2,4));
        graph[2].add(new Eadge(2,1));
       

         graph[3].add(new Eadge(3,0));
        graph[3].add(new Eadge(3,4));

         graph[4].add(new Eadge(4,3));
           graph[4].add(new Eadge(4,3));

        
      System.out.println( IsCycle(graph));
       
    }

    
}


