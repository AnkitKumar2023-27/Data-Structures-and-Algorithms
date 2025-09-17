public class FloyedWarsall {
    public static void FloydWarshellAlgo(int matrics[][]){
        // if distance given is -1 it means distance isnot exits for that place 

        int n=matrics.length;
        int m=matrics[0].length;
        for( int i=0; i<n;i++){
            for( int j=0;j<m;j++){
                if(matrics[i][j]==-1){
                    matrics[i][j]=Integer.MAX_VALUE;

                }

            }
        }
        for( int via=0;via<n;via++){
            for( int i=0; i<n;i++){
            for( int j=0;j<m;j++){
                if(matrics[i][via]!=Integer.MAX_VALUE&&matrics[via][j]!=Integer.MAX_VALUE)
                matrics[i][j]=Math.min(matrics[i][j],matrics[i][via]+matrics[via][j]);
            }}
        }
        for( int i=0; i<n;i++){
            for( int j=0;j<m;j++){
                if(matrics[i][j]==Integer.MAX_VALUE){
                    matrics[i][j]=-1;
                }
            }}
             for( int i=0; i<n;i++){
            for( int j=0;j<m;j++){
                System.out.print(matrics[i][j]+" ");
            }
        System.out.println();
    
    }
            
    }
    public static void main(String[] args) {
         int[][] graph = {
            {0,   4,   2,  -1},
            {-1,  0,  -1,  3},
            {-1,  5,   0,  1},
            {3,  -1,  -1,  0}
        };
        FloydWarshellAlgo(graph);
    }
}
