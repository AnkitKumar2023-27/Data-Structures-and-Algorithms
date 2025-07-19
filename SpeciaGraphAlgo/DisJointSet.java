public class DisJointSet {
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

    public static void main(String[] args) {

        union(1,3);
        System.out.println(Find(1));
        
        
    }
}
