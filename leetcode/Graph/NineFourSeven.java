public class NineFourSeven {

    public static class DisjointSet{
         static int parent[];
         static int  rank[];

         public  DisjointSet(int n){
            parent=new int[n];
            rank =new int[n];
            for( int i=0;i<n;i++){
                parent[i]=i;
                 rank[i]=1;
            }

         }
         public static int findParnet(int n){
            if(n==parent[n]){
                return n;

            }else{
                return parent[n]=findParnet(parent[n]);
            }
         }
         public static void uninon( int a, int b){
            int parA=findParnet(a);
            int parB=findParnet(b);
            if(parA==parB) return;
            if(rank[parA]==rank[parB]){
                parent[parA]=parB;
                rank[parB]++;
            }
            else if(rank[parA]>rank[parB]){
                parent[parB]=parA;
            }else{
                parent[parA]=parB; 
            }

         }

    }
    public static int removeStones(int[][] stones) {
         int n=stones.length;
         DisjointSet ds=new DisjointSet(n);
         for( int i=0;i<n;i++){
            for( int j=0;j<n;j++){
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
                    ds.uninon(i, j);
                }
            }
         }
     
         int component=0;
         for(int i=0;i<n;i++){
            if(ds.parent[i]==i){
                component++;

            }
         }
        
        return n-component;
    }
    public static void main(String[] args) {
       int  stones [][]= {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
       System.out.println(removeStones(stones));
    }
}

