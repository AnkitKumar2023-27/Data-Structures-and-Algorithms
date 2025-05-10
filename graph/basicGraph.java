import java.util.ArrayList;

public class basicGraph {

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

    
    public static void main(String[] args) {
         int v=5;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
     
        graph[0].add(new Eadge(0,1,5));

        graph[1].add(new Eadge(1,0,5));
        graph[1].add(new Eadge(1,1,2));
        graph[1].add(new Eadge(1,1,3));

        graph[2].add(new Eadge(2,1,1));
        graph[2].add(new Eadge(2,3,3));
        graph[2].add(new Eadge(2,4,3));


        graph[3].add(new Eadge(3,1,3));
        graph[3].add(new Eadge(3,1,2));
        
        graph[4].add(new Eadge(4,2,2));
       

        for(int i=0;i<graph.length;i++){
            Eadge e=graph[2].get(i);
            System.out.println(e.dest);
        }

       
        
    }
}