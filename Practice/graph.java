import java.util.*;

public  class graph {
   public static class  Eadge {
    int  src; 
     int dest;
      int wt;
      public Eadge( int s, int d, int w){
        this.src=s;
         this.dest=d;
         this.wt=w;
      }
   
    
   }
   public static void graphCreation(ArrayList<Eadge>graph[]){

    for ( int  i=0;i<graph.length;i++){
        graph[i] =new ArrayList<>();
    };
   
      graph[0].add(new Eadge(0, 1, 1));
      graph[0].add(new Eadge(0,2,1));
      graph[1].add(new Eadge(1,3,1));
      graph[2].add(new Eadge(2,4,1));
      graph[3].add(new Eadge(3,5,1));
      graph[4].add(new Eadge(4,5,1));
      graph[5].add(new Eadge(5,6,1));


   }

   public static void BFS(ArrayList<Eadge>graph[]){
    boolean  vis[]= new boolean[graph.length];
     for( int i=0;i<graph.length;i++){
       if(!vis[i]){
          BfsUtil(graph,vis,i);
       }
      
     }

   };
   public static void BfsUtil(ArrayList<Eadge>graph[],boolean vis[] ,int start){
    Queue <Integer>q=new LinkedList<>();
    q.add(start);
    while (!q.isEmpty()) {
        int curr=q.remove();
       
        if(!vis[curr])
        {
        System.err.print(curr+" ");
        vis[curr]=true; 
        for( int i=0;i<graph[curr].size();i++){
            Eadge e=graph[curr].get(i);
            q.add(e.dest);
        }
        }
        
    }
    
   }

   //DFS
   public static void DFS( ArrayList<Eadge>graph[]){
    boolean vis[]=new boolean[graph.length];
     for( int i=0; i<graph.length;i++){
      if(!vis[i]){
        DFS_Util(graph,vis, i);
      }
     }
   }

   public  static void DFS_Util( ArrayList<Eadge>graph[],boolean vis[], int start){
         System.out.print(start+" ");
         vis[start]=true;

          for( int i=0;i< graph[start].size();i++){
            Eadge e=graph[start].get(i);
            if (!vis[e.dest]) {
              DFS_Util(graph, vis, e.dest);
              
            }
          }
   }
  // HASPATH CHECKING 
     public static boolean HasPath( ArrayList<Eadge>graph[],int dest){
    boolean vis[]=new boolean[graph.length];
     for( int i=0; i<graph.length;i++){
      if(!vis[i]){
        if (HashPath_Util (graph,i ,dest,vis)) {
          return true;
        } 
      }
     }
     return false;
   }
   public static  boolean HashPath_Util( ArrayList<Eadge>graph[], int src ,int dest, boolean vis[]){
    if(src==dest){
      return true;
    }
    vis[src]=true;
       for( int i=0;i< graph[src].size();i++){
            Eadge e=graph[src].get(i);
            if (!vis[e.dest]&&HashPath_Util(graph,e.dest,dest,vis)) {
             return  true;
            
              
            }
            }
            return false;

   }

//Part two Graph
// Is cycle exits in graph Using Graph 
   public static boolean IsyCycle( ArrayList<Eadge>graph[]){
    boolean vis[]=new boolean[graph.length];
     for( int i=0; i<graph.length;i++){
      if(!vis[i]){
        if (IsCycle_Util (graph,i,vis,-1)) {
          return true;
        } 
      }
     }
     return false;
   }
public static boolean IsCycle_Util(ArrayList<Eadge>[] graph, int curr, boolean vis[], int parent) {
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
        Eadge e = graph[curr].get(i);

        
        if (!vis[e.dest]) {
            if (IsCycle_Util(graph, e.dest, vis, curr)) {
                return true;
            }
        } 
    
        else if (e.dest != parent) {
            return true;
        }
    }
    return false;
}

  

    public static void main(String[] args) {
        int v=7;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge>graph[]=new ArrayList[v];
        graphCreation(graph);

         System.out.println( " BFS ");
        BFS(graph);
        System.out.println();

        System.out.println("DFS");
        DFS(graph);


        System.out.println();
        System.out.println("HASHPATH");
        System.out.println(HasPath(graph, 6));

        System.out.println("cycle Detection");
        System.out.println(IsyCycle(graph));
    }
    
}
