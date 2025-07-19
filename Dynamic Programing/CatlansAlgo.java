import java.util.Arrays;

public class CatlansAlgo {
     public static int catlansRec( int n){
        if( n==0||n==1){
            return 1;
        }
       int ans=0;
      for( int i=0;i<=n-1;i++){
            ans+= catlansRec(i)*catlansRec(n-i-1);
        }
        return ans;

       
    
     }
    
      public static int catlansMemo(int n, int dp[]){
         if( n==0||n==1){
            return 1;
        }

        int ans=0;
         if(dp[n]!=-1){
            return dp[n];

     }

      for( int i=0;i<=n-1;i++){
          ans+= catlansMemo(i,dp)*catlansMemo(n-i-1,dp);
           
        }
 dp[n]=ans;
        return dp[n];

      }
    public static int catlanstab(int n){

         int dp[]=new int[n+1];
         dp[0]=dp[1]=1;
          
          for( int i=2;i<=n;i++){
            for( int j=0;j<i;j++){
                dp[i]=dp[j]*dp[i-j-1];
            }
            
          }

return dp[n];
       

      }

    

    public static void main(String[] args) {
        int n=5;
        System.out.println( catlansRec(n));
         int dp[]=new int[n+1];

         Arrays.fill(dp,-1);
         System.out.println(catlansMemo(n, dp));
         System.out.println(catlansRec(n));

      

       
        
    }
    
}
