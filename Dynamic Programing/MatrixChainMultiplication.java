public class MatrixChainMultiplication {
    public  static int MCM( int arr[], int i, int j ){

        if(i==j ){
             return 0;
        }
         int ans=Integer.MAX_VALUE;
         for ( int k=i;k<=j-1;k++){
            int cost1=MCM(arr,i, k);
             int cost2=MCM(arr,k+1,j);
             int cost3=arr[i-1]*arr[k]*arr[j];
              int finalCost=cost1+cost2+cost3;
               ans=Math.min(ans, finalCost);

         }

          return ans;

    }

     public  static int MCM_Memo( int arr[], int i, int j ,int dp[][]){

        if(i==j ){
             return 0;
        }

         

         if( dp[i][j]!=-1){
            return dp[i][j];
         }
         int ans=Integer.MAX_VALUE;
         for ( int k=i;k<=j-1;k++){
            int cost1=MCM_Memo(arr,i, k,dp);
             int cost2=MCM_Memo(arr,k+1,j,dp);
             int cost3=arr[i-1]*arr[k]*arr[j];
              int finalCost=cost1+cost2+cost3;
               ans=Math.min(ans, finalCost);
               dp[i][j]=ans;
 
         };
          return dp[i][j];
         

    };

    public static void main(String[] args) {
         int arr[]={ 1,2,3,4,3};

          int n=arr.length;
         System.out.println(MCM(arr, 1,n-1));
         int dp[][]=new int[n+1][n+1];
         for( int i=0; i<=n;i++){
            for( int j=0;j<=n;j++){
                dp[i][j]=-1;
            }

         }
        System.out.println(MCM_Memo(arr, 1, n-1, dp));    
    }
   
}
