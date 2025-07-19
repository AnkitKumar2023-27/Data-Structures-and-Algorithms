import java.util.*;



public class topologySorting {
    
       public static class Eadge{
        int src;
        int dest;
        
      public Eadge(int src,int dest){
        this.src=src;
        this.dest=dest;
       

        }
        

    }
    
public static void topSort(ArrayList<Eadge>graph[]){

    boolean vis[]=new boolean[graph.length];
    Stack<Integer>Stack=new Stack<>();

    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
            topSortutil(graph,i,vis,Stack);
        }
    }

    while ((!Stack.isEmpty())) {

        System.out.print(Stack.pop()+" ");
        
    }
}

public static void topSortutil(ArrayList<Eadge>graph[],int curr,boolean vis[], Stack<Integer> stack){

    vis[curr]=true;
    for( int i=0;i< graph[curr].size();i++){
        Eadge e=graph[curr].get(i);
        if(!vis[e.dest]){
            topSortutil(graph,e.dest, vis, stack);

        }
    }
    stack.push(curr);

}

    public static void main(String[] args) {
        

               int v=7;
        @SuppressWarnings("unchecked")
        ArrayList<Eadge> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++){

            graph[i]=new ArrayList<>();
        }
     
         graph[0].add(new Eadge(0, 1));
        graph[0].add(new Eadge(0, 2));

        graph[1].add(new Eadge(1, 3));

        graph[2].add(new Eadge(2, 3));
        graph[2].add(new Eadge(2, 4));

        graph[3].add(new Eadge(3, 5));

        graph[4].add(new Eadge(4, 5));

        topSort(graph);
    }
}
