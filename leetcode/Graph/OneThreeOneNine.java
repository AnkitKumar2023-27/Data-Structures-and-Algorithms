public class OneThreeOneNine {

    public static class DisjointSet{
      static  int parent[];
      static   int rank[];
         public  DisjointSet(int n){
            parent=new int[n];
            rank =new  int[n];
            for( int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
         }
        public static int find( int n){
            if(parent[n]==n){
                return n;

            }else{
                return parent[n]=find(parent[n]);
            }
        }

        public static void union( int a, int b){
            int parA=find(a);
            int parB=find(b);
            if(parA==parB){
                return;
            }
            if( rank[parA]==rank[parB]){
                parent[parA]=parB;
                rank[parB]++;
            }else if (rank[parA]>rank[parB]) {
                parent[parB]=parA;
                
            }else{
               parent[parA]=parB; 
            }
            
        }
    }
      @SuppressWarnings("static-access")
    public static int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int extraEages=0;
        int m=connections.length;
        for( int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if (ds.find(u)==ds.find(v)) {

                extraEages++;
            }else{
                ds.union(u, v);
            }
        }
        int totalCompo=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i){
                totalCompo++;
            }
        }
        int ans=totalCompo-1;
        if(extraEages>=ans){
            return ans;
        }else{
            return -1;
        }



        
    }
    public static void main(String[] args) {
        int n = 6;
int[][] connections = {
    {0, 1},
    {0, 2},
    {0, 3},
    {1, 2},
    {1, 3}
};
System.out.println(makeConnected(n, connections));
    }
    
}
