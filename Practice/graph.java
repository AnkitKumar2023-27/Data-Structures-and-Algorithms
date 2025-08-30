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

    public static void main(String[] args) {
        int v=7;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge>graph[]=new ArrayList[v];
        graphCreation(graph);

         System.out.println( " BFS n");
        BFS(graph);
        System.out.println();

        System.out.println("DFS");
        
    }
    
}
