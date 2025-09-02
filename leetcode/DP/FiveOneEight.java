public class FiveOneEight {
      public static int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        dp[0][0]=1;
        for( int i=1;i<n+1;i++){
            dp[i][0]=1;
        }
           for( int i=1;i<amount+1;i++){
            dp[0][i]=0;
        }
        

           for( int i=1;i<n+1;i++){
            for( int j=1;j<amount+1;j++){
                if( j>=coins[i-1]){
               dp[i][j]  =  Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
              
                
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
public static void main(String[] args) {
    int arr[]={1,2,5};
    int amount=11;
    System.out.println(coinChange(arr, amount));
    
}
}
