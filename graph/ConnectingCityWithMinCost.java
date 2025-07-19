import java.util.PriorityQueue;

public class ConnectingCityWithMinCost {

public static class Edge implements Comparable<Edge>{
    int dest;
    int cost;
    public Edge(int d,int  c){
        this.dest=d;
        this.cost=c;
    }
     @Override
     public int compareTo(Edge e2){
        return this.cost-e2.cost;
     }  
}
public static int ConnectingCityWithMin(int cities[][]){
    boolean vis[]=new boolean[cities.length];
    PriorityQueue<Edge>pq=new PriorityQueue<>();

    pq.add(new Edge(0, 0));
    int finalCost=0;
while (!pq.isEmpty()) {
    Edge e=pq.remove();

    if(!vis[e.dest]){
        vis[e.dest]=true;
        finalCost+=e.cost;
        for( int i=0;i<cities[e.dest].length;i++){
            if(cities[e.dest][i]!=0){
                pq.add(new Edge(i, cities[e.dest][i]));
                
            }

        }
    }
    
}



return finalCost;



}




public static void main(String[] args) {

            int cities[][]={{0,1,2,3,4},
                            {1,0,5,0,7},
                            {2,5,0,6,0},
                            {3,0,6,0,0},
                            {4,7,0,0,0}};
                            
System.out.println( ConnectingCityWithMin(cities)   );
                        
            
};




    
}
