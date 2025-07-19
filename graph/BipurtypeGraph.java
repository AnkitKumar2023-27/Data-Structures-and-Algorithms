import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipurtypeGraph {


   

    public static class Eadge{
        int src;
        int dest;
        int wt;
      public Eadge(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;

        }
        

    }

    public static boolean Bipertype(ArrayList<Eadge>graph[]){

        int col[]=new int[graph.length];
         for( int i=0;i<graph.length;i++){
            col[i]=-1;
        }

    Queue<Integer>q=new LinkedList<>() ;

    for(int i=0;i<graph.length;i++){
        if(col[i]==-1){
            col[i]=0;
            q.add(i);
        }
    } 

    while(!q.isEmpty()){

        int curr=q.remove();
         for( int j=0;j<graph[curr].size();j++){
               Eadge e=graph[curr].get(j);

               if(col[e.dest]==-1){
                int nextCol=col[curr]==0?1:0;
                col[e.dest]=nextCol;
                q.add(e.dest);

               }
               if(col[e.dest]==col[curr]){
                return false;
               }


         }       

    }
     return true;
    }
   


    public static void main(String[] args) {

            int v=7;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++){

            graph[i]=new ArrayList<>();
        }
     
        graph[0].add(new Eadge(0,1,5));
        graph[0].add(new Eadge(0,2,3));

        graph[1].add(new Eadge(1,3,5));
        graph[1].add(new Eadge(1,0,5));
        
        graph[2].add(new Eadge(2,4,2));
        graph[2].add(new Eadge(2,0,3));
       

        graph[3].add(new Eadge(3,5,1));
        graph[3].add(new Eadge(3,1,1));

        graph[4].add(new Eadge(4,5,3));
        graph[4].add(new Eadge(4,2,3));


         graph[5].add(new Eadge(5,6,3));
         graph[5].add(new Eadge(5,3,3));
         graph[5].add(new Eadge(5,4,3));


        
        graph[6].add(new Eadge(6,5,3));
     

    System.out.println(Bipertype(graph));

      
    }
    
}
