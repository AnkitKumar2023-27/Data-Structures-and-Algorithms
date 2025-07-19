import java.util.ArrayList;




public class AllpathofDirGraph {

    public static class Edge{
        int src;
        int dest;
        
        public Edge(int src,int dest){
            this.src=src;
             this.dest=dest;

        }
    }

    public static void AllPath( ArrayList<Edge>graph[] ,int s, int dest, String  Path){
        if(s==dest){
            System.out.println(Path+dest);
            return;

        }
         for ( int i=0;i<graph[s].size();i++){
              Edge e = graph[s].get(i);
                AllPath(graph,e.dest,dest,Path+s);
         }
    }



    
    public static void main(String[] args) {
        int v=6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] =new  ArrayList[v];
         for ( int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
         }
       
    graph[0].add(new Edge(0,3));
    graph[2].add(new Edge(2,3));
    graph[3].add(new Edge(3,1));
    graph[4].add(new Edge(4,0));
    graph[4].add(new Edge(4,1));
    graph[5].add(new Edge(5,0));
     graph[5].add(new Edge(5,2));
         
       
     int s=5;
     int d=1 ;
     String path ="";
    

       AllPath(graph,s,d,path);

        
        
    }
}
