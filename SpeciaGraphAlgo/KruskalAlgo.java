import java.util.ArrayList;

import java.util.Collections;

public class KruskalAlgo {


      public static class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int wt) {
        this.src = s;
        this.dest = d;
        this.wt = wt;
    }

    @Override
    public int compareTo(Edge other) {
        return this.wt - other.wt;
    }
}

     public static void Creategraph( ArrayList<Edge>graph,int v){

        graph .add(new Edge(0,1,10));
        graph .add(new Edge(0,3,30));
        graph.add(new Edge(0,2,15));
        
        graph.add(new Edge(1,3,40));
        graph.add(new Edge(2,3,50));
       
    }

    static int n=7;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    static{
         for ( int i=0;i<n;i++){
        par[i]=i;
        rank[i]=0;
     }

    }

    
     public static int Find(int x){
        if(par[x]==x){
            return x;
        }
        return Find(par[x]);

     }

     public static void union(int a,int b){
        int parA=Find(a);
        int parB=Find(b);

          if (parA == parB) {
            return; // Already in the same set
        }

        if(rank[parA]==rank[parB]){
            par[parA]=parB;
            rank[parB]++;
        }else if(rank[parA]<rank[parB]){
             par[parA]=parB;


        }else{
            par[parB]=parA;
        }

     }


     public static void Kruskal(ArrayList<Edge>edges,int v){
       Collections.sort(edges);
       int cost=0;
       for(int i= 0;i<v-1;i++){
        Edge e=edges.get(i);
       int parA=Find(e.src);
      int   Parb=Find(e.dest);
      if(parA!=Parb){
        union(parA, Parb);
        cost+=e.wt;
    }
       }

       System.out.println(cost);

    



     }



    public static void main(String[] args) {


         
        int n=4;
        ArrayList<Edge>edges=new ArrayList<>();

        Creategraph(edges,n );
        Kruskal(edges,n);
    
        
    }
    
}
