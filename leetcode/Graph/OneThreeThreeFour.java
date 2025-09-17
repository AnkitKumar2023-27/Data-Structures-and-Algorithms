import java.util.Arrays;





public class OneThreeThreeFour {
      public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        
        int dis[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
             dis[i][i] = 0;
        }

         for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            dis[u][v]=wt;
            dis[v][u]=wt;
            //beacause of 2d matrics eadges joint feom the both side
         }
       for( int k=0; k<n;k++){
           for( int i=0;i<n;i++){
            for( int j=0;j<n;j++){
                if(dis[i][k]!=Integer.MAX_VALUE&&dis[k][j]!=Integer.MAX_VALUE){
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }

         }
       }
      
       int maxcity=n;
       int city=-1 ;
      for( int i=0;i<n;i++){
        int cnt=0;
            for( int j=0;j<n;j++){
             if (dis[i][j] <= distanceThreshold) {
            cnt++;
            }       

            }
            if(cnt<=maxcity){
                maxcity=cnt;
                city=i;

            }

        }
        return city;  
     
    }
    public static void main(String[] args) {
        int n = 5;
int[][] edges = {
    {0, 1, 2},
    {0, 4, 8},
    {1, 2, 3},
    {1, 4, 2},
    {2, 3, 1},
    {3, 4, 1}
};
int distanceThreshold = 4;
  System.out.println(findTheCity(n, edges, distanceThreshold));


    }

    
}
