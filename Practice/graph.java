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

//bipertype  graph//\


public static boolean isBypertype(ArrayList<Eadge>graph[]){
   int col[]=new int[ graph.length];
   Arrays.fill(col,-1);
     Queue<Integer>q=new LinkedList<>();
     for( int i=0;i<graph.length;i++){
           if(col[i]==-1){
             col[i]=0;
             q.add(i);
           
           }     };

    
              while (!q.isEmpty()) {
                int curr=q.remove();
                for( int i=0; i<graph[curr].size();i++){
                  Eadge e=graph[curr].get(i);
                if(col[e.dest]!=-1){
                      int NextCol=col[curr]==0?1:0;
                      col[e.dest]=NextCol;
                      q.add(e.dest);
                }else if(col[curr]==col[e.dest]){
                  return false;
                }
                }
               
            }
            return true;

          
       
};

 public static void graphCreation2(ArrayList<Eadge>graph[]){

    for ( int  i=0;i<graph.length;i++){
        graph[i] =new ArrayList<>();
    };
   
      graph[2].add(new Eadge(2, 3, 1));
      graph[3].add(new Eadge(3,1,1));
      graph[4].add(new Eadge(4,0,1));
      graph[4].add(new Eadge(4,4,1));
      graph[5].add(new Eadge(5,0,1));
    
      graph[5].add(new Eadge(5,2,1));


   }
//topogycal Sort  using bfs
public static void calInd( ArrayList<Eadge>graph[], int indegree[]){
  for( int i=0;i<graph.length;i++){
    for( int j=0 ; j<graph[i].size();j++){
      Eadge e=graph[i].get(j);
      indegree[e.dest]++;
    }
  }

}
public static void topogycalSort( ArrayList<Eadge>graph[]){
   Queue<Integer>q=new LinkedList<>();
   int indegree[]=new int[graph.length];
    calInd(graph, indegree);

    for(int i=0;i<graph.length;i++){
       if(indegree[i]==0){
        q.add(i);
       }

    }
     while (!q.isEmpty()) {
      int curr=q.remove();
      System.out.print(curr+" ");
      for( int i=0;i<graph[curr].size();i++){
        Eadge e=graph[curr].get(i);
         indegree[e.dest]--;
        if(indegree[e.dest]==0){
          q.add(e.dest);
        }

    
      }
      
     }


    }


    // graph for the minimum spanning tree


 public static void graphCreation3(ArrayList<Eadge>graph[]){

    for ( int  i=0;i<graph.length;i++){
        graph[i] =new ArrayList<>();
    };
   
      graph[0].add(new Eadge(0, 1, 10));
      graph[0].add(new Eadge(0,2,15));
      graph[0].add(new Eadge(0,3,30));
      graph[1].add(new Eadge(1,0,10));
      graph[1].add(new Eadge(1,3,40));
    
      graph[2].add(new Eadge(2,0,15));
       graph[2].add(new Eadge(2,3,50));
         graph[3].add(new Eadge(3,1,40));
           graph[3].add(new Eadge(3,2,15));

   }
   
    public static class pair2 implements Comparable<pair2> {
        int v;
         int cost;
         public pair2(int v, int cost){
             this.v=v;
             this.cost=cost;
             
         }
         @Override
         public int compareTo(pair2 p2) {
             return this.cost-p2.cost;
          
         }

    
      
    }

public static void prims(ArrayList<Eadge>graph[]){
  boolean  vis[]=new boolean[graph.length];
  PriorityQueue<pair2>pq=new PriorityQueue<>();
  pq.add(new pair2(0, 0));
  int MinTotalCost=0;
  while(!pq.isEmpty()){
    pair2 curr=pq.remove();

    if(!vis[curr.v]){
      vis[curr.v]=true;
      MinTotalCost+=curr.cost;

      for(int i=0;i<graph[curr.v].size();i++){
        Eadge e=graph[curr.v].get(i);
        pq.add(new pair2(e.dest,e.wt));
      }


    }
  }
    System.out.println(MinTotalCost);
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

        System.out.println();
        System.out.println("Cheking Of Bypertype");
        System.out.println(isBypertype(graph));

        //topologycal graph

        System.out.println("topologycal sort by bFS");
        int u=7;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge>graph2[]=new ArrayList[u];
        graphCreation2(graph2);
        topogycalSort(graph2);

      System.out.println();
      System.out.println("Minmum spanning tree");

        //minimum sapnning tree
        int w=9; 
    @SuppressWarnings("unchecked")
    ArrayList<Eadge>    graph3[]=new ArrayList[w];
      graphCreation3(graph3);
      prims(graph3);
        
    
    }
    
}
