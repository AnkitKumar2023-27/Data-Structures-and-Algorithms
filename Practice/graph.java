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

public static class info implements Comparable<info>{
  int des;
   int cost;
   public info( int d, int c){
            this.des=d;
            this.cost=c;

   }
   public int compareTo(info p2){
    return this.cost-p2.cost;
   }
}
//find minmum Dis/
public static int minDis( int arr[][]){
  boolean vis[]=new boolean[arr.length];
  PriorityQueue<info>pq=new PriorityQueue<>();
  pq.add(new info(0, 0));
  int mindis=0;
  while( !pq.isEmpty()){
      info curr=pq.remove();

      if(!vis[curr.des]){
        vis[curr.des]=true;
         mindis+=curr.cost;

        for( int i=0; i< arr[curr.des].length;i++){
          if(arr[curr.des][i]!=0){

            pq.add(new info(i, arr[curr.des][i]));
          }

        }
      }
}
return mindis;

}


//////////////////////////////Discuss and question on the Disjpint sets ////////////////////////////////////////////////////
//// base of find op ration and  union //////////////
static int n=7;
static int rank[]=new int[n];
 static int par[]=new int[n];
 

 public static void init(){
  for( int i=0 ; i<n;i++){
       par[i]=i;
 }
 }
  public static  int find(int x ){
    if(x==par[x]){
      return x;
    }
    
      return find(par[x]);
  
  };

public static void union( int a , int b){
  int parA=find(a);
   int parB= find(b);
   if( rank[parA]==rank[parB]){
    par[parB]=parA;
    rank[parB]=rank[parA];
    rank[parA]++;
   }
   else if(rank[parA]>rank[parB]){
            par[parB]=parA;
   }else{
    rank[parA]=parB;

   }
}

///kruskal Algo bAsed on the Disjoint sets
/// 
 
 public static void graphCreationKr(ArrayList<EadgeKr>Eadges){

   

                Eadges .add(new EadgeKr(0, 1, 10));
                Eadges  .add(new EadgeKr(0,2,15));
                  Eadges.add(new EadgeKr(0,3,30));
              
                  Eadges .add(new EadgeKr(1,3,40));

                    Eadges.add(new EadgeKr(2,3,50));
          

   }
   
    public static class EadgeKr implements Comparable<EadgeKr> {
        int src;
         int dest;
         int wt;
         public EadgeKr(int s, int d, int w){
             this.src=s;
             this.dest=d;
             this.wt=w;
             
         }
         @Override
         public int compareTo(EadgeKr p2) {
             return this.wt-p2.wt;
          
         }

    
      
    }

public static void kruskalAlgo( ArrayList<EadgeKr>Eadges, int v){
  Collections.sort(Eadges);
  init();
  int minCos=0;
  for( int i=0;i<v-1;i++){
    EadgeKr e=Eadges.get(i);
    int src=e.src;
    int des=e.dest;
    int ParSrc=find(src);
     int ParDest=find(des);
     if(ParSrc!=ParDest){
      union(src, des);
          minCos+=e.wt;
     }


  }

  System.out.println("Total min Cost= "+minCos);

}

// leetcode 737 based on floodFill


  public  int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean vis[][]=new boolean[image.length][image[0].length];
     int orgCol=image[sr][sc];
     if(color==orgCol){
        return image;
     }
     helper(image, sr,sc,color, vis,orgCol);
     return image;
        
    }
    public static void helper( int image[][], int sr, int sc, int color , boolean vis[][],int orgCol){
      if(sr<0||sr>=image.length||sc<0||sc>=image[0].length||image[sr][sc]!=orgCol||vis[sr][sc]){
        return ;
      
      }
         vis[sr][sc]=true;
         image[sr][sc]=color;
       
    
     
      helper(image, sr+1, sc, color, vis,orgCol);
      helper(image, sr, sc+1, color, vis,orgCol);
      helper(image, sr, sc-1, color, vis,orgCol);
      helper(image, sr-1, sc, color, vis,orgCol);

   
     }  
    public static  void topsort(ArrayList<Eadge>graph[], int curr,Stack<Integer>s, boolean vis[]){
      vis[curr]=true;
      for( int i=0;i<graph[curr].size();i++){
        Eadge e=graph[curr].get(i);
        if ((!vis[e.dest])) {
          topsort(graph, e.dest,s, vis);
        }
      }
      s.push(curr);

    } ;

        public static  void DFSKR(ArrayList<Eadge>graph[], boolean vis[],int curr){
      vis[curr]=true;
      System.out.print(curr+" ");
      for( int i=0;i<graph[curr].size();i++){
        Eadge e=graph[curr].get(i);
        if ((!vis[e.dest])) {
          DFSKR(graph,vis,e.dest);
        }
      }
     

    } ;

@SuppressWarnings("unchecked")
public static void kosaRajuAlgo(ArrayList<Eadge>graph[], int v){
     boolean vis[]=new boolean[graph.length];
     Stack<Integer>s=new Stack<>();

     for( int i=0;i<graph.length;i++){
      if(!vis[i]){
        topsort(graph,i,s,vis);
      }
     }


   //transpose
     ArrayList<Eadge>[] transpose = new ArrayList[v]; 
   for( int i=0;i<v; i++){ 
      vis[i]=false;
     transpose[i]=new ArrayList<>();
   } 

   for( int i=0;i<v;i++){
    for( int j=0; j<graph[i].size();j++){
      Eadge e=graph[i].get(j);
      transpose[e.dest].add(new Eadge(e.dest, e.src, 1));

    }
   }

   while (!s.isEmpty()) {
    int curr=s.pop();
    if(!vis[curr]){
        System.out.print("SCC =");
        DFSKR(transpose, vis, curr);
    }
      System.out.println();

    
   }
 
}
       public static void graphCreatioKR(ArrayList<Eadge>graph[],int v){

    for ( int  i=0;i<v;i++){
        graph[i] =new ArrayList<>();
    };
   
      graph[0].add(new Eadge(0, 2, 1));
      graph[0].add(new Eadge(0,3,1));
      graph[1].add(new Eadge(1,0,1));
      graph[2].add(new Eadge(2,1,1));
      graph[3].add(new Eadge(3,4,1));
      // graph[4].add(new Eadge(4,5,1));
      // graph[5].add(new Eadge(5,6,1));


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


      //min city distance
// min distance question 
System.out.println("minmum distance betwen the cities");
int  cities[][]={{0,1,2,3,4,},
              {1,0,5,0,7},
            {2,5,0,6,0},
          {3,0,6,0,0},
          {4,7,0,0,0}};
          
        System.out.println(minDis(cities));


///////////////// DISJOINT SETS////////////////

System.out.println(); 

System.out.println("Disjoint sets ");
init();
union(1,3);
System.out.println("Parent of 3 chhange because of unionof 1,3 = "+ find(3));
union(2,4);
union(3,6);
union(2, 3);
System.out.println(find(4));
System.out.println(find(6));

// Kruskal Algo//

System.out.println();
System.out.println("kruskal Algo");

ArrayList<EadgeKr>eadges=new ArrayList<>();
int n=4;
graphCreationKr(eadges);
kruskalAlgo(eadges, n);
System.out.println();

System.out.println("KosaRajo algorithm for Storngly Connected component ");
int N=5;
@SuppressWarnings("unchecked")
ArrayList<Eadge>graphKR[]=new ArrayList[N];
 graphCreatioKR(graphKR,N);
kosaRajuAlgo(graphKR, N);


    
    }
     
}
