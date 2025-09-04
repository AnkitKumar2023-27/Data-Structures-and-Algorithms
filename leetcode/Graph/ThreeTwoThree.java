import java.util.ArrayList;



class ThreeTwoThree {
 public static  class Eadge{
        int src;
         int dest;
      public   Eadge( int s, int d){
          this.src=s;
          this.dest=d;

         }
    }

 @SuppressWarnings("unchecked")
public static int countComponents(int n, int[][] edges) {
     ArrayList<Eadge>graph[]=new ArrayList[n];
     for( int i=0 ; i<n;i++){
        graph[i]= new ArrayList<>();
          };

     

     for( int i=0;i<edges.length;i++){
         int s=edges[i][0];
         int d=edges[i][1];
         graph[s].add(new Eadge(s, d));

     }
      boolean vis[]=new boolean[n];
       int count=0;
       for( int i=0;i<n;i++){
        if(!vis[i]){
            dfs(graph, i,vis);
            count++;
        }
       }
       return count;

 }
 public static void  dfs(ArrayList<Eadge>graph[],int  curr, boolean vis[]){
    vis[curr]=true;
    for( int i=0;i<graph[curr].size();i++){
        Eadge e=graph[curr].get(i);
        if(!vis[e.dest]){
            dfs(graph,e.dest,vis);
        }
    }
 }


    public static void main(String[] args) {
     int   n = 5;
        int edges[][]={{ 0,1},{1,2},{3,4}};
        System.out.println(countComponents(n, edges));
        
    }


    
}