import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class TwoZeroSeven {
    public static class Eadge {
         int src;
          int dest;
          public Eadge( int s, int d){
            this.src=s;
             this .dest=d;
          }
           
    }
 @SuppressWarnings("unchecked")
public static boolean canFinish(int numCourses, int[][] prerequisites) {
    
      ArrayList<Eadge>graph[]= new ArrayList[numCourses];
      for( int i=0; i<numCourses; i++){
        graph[i]=new ArrayList<>();
      };
       for( int i=0;i<prerequisites.length;i++){
        int src=prerequisites[i][0];
         int dest=prerequisites[i][1];
         graph[dest].add(new Eadge(dest,src));


       }
       if(topoSort(graph)){
        return true;
       }else{
         return false;
       }

        
    }
    public  static boolean topoSort(ArrayList<Eadge>graph[]){
      int n =graph.length;
      int indegree[]=new int[n];
      Queue<Integer>q=new LinkedList<>();
      calInde(graph, indegree);
      for( int i=0; i<indegree.length;i++){
        if( indegree[i]==0){
          q.add(i);

        }
      }
      ArrayList<Integer>topo=new ArrayList<>();
      while (!q.isEmpty()) {
        int curr=q.remove();
        topo.add(curr);
        for( int i=0;i<graph[curr].size();i++){
          Eadge e=graph[curr].get(i);
          indegree[e.dest]--;
        if(indegree[e.dest]==0){
          q.add(e.dest);
        }

        }
        
      }
      if(topo.size()==graph.length){
        return true;

      }
       else
       {
        return false;
       }
    }

    public static void calInde(ArrayList<Eadge>graph[], int indegree[]){
      for( int i=0;i<graph.length;i++){
        int curr=i;
        for( int j=0;j<graph[curr].size();j++){
          Eadge e=graph[curr].get(j);
          indegree[e.dest]++;

        }
      }
    }
    
    public static void main(String[] args) {
    int   prerequisites[][] = {{1,0}};
      int n=2;
      System.out.println(canFinish(n, prerequisites));
    }

    
}
