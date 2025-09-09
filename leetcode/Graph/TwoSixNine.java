import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TwoSixNine {

    

    public static class Eadge {
         int src;
          int dest;
          public Eadge( int s, int d){
            this.src=s;
             this .dest=d;
          }
           
    }
 @SuppressWarnings("unchecked")
public static String alianDic(String arr[], int k ,int n) {
    
      ArrayList<Eadge>graph[]= new ArrayList[k];
      for( int i=0; i<k; i++){
        graph[i]=new ArrayList<>();
      };
      for( int i=0;i<n-1; i++){
        String s1=arr[i];
         String s2=arr[i+1];
         int len=Math.min(s1.length(), s2.length());
         
         for( int ptr=0; ptr<len;ptr++){

            if(s1.charAt(ptr)!=s2.charAt(ptr)){
                int first=s1.charAt(ptr)-'a';
                 int second=s2.charAt(ptr)-'a';
                 graph[first].add(new Eadge(first, second));
                 break;
            }
         }
      }

      List<Integer>topo=topoSort(graph,k);
      if (topo.size() < k) return "";

        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            ans.append((char) (it + 'a'));
        }
        return ans.toString();
    


    }

   public static List<Integer> topoSort(ArrayList<Eadge>[] graph, int k) {
        int n = graph.length;
        int indegree[] = new int[n];
        Queue<Integer> q = new LinkedList<>();

        calcIndegree(graph, indegree);
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> safe = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            safe.add(curr);
            for (int j = 0; j < graph[curr].size(); j++) {
                Eadge e = graph[curr].get(j);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) q.add(e.dest);
            }
        }
        
      return safe;
    }
   public static void calcIndegree(ArrayList<Eadge>[] graph, int indegree[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Eadge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    

}

public static void main(String[] args) {
         String arr[]={
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
                };

                int k=5;int
                 n=arr.length;
                 System.out.println(alianDic(arr, k, n));
}
}


