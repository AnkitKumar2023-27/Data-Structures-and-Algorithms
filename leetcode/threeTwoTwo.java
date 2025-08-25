public class threeTwoTwo {

    public static int CoinExchange(int arr[], int n , int w){

         if(n==0){
           return Integer.MAX_VALUE;
         }
        if(w==0){
             return 0;
        }

    
    if(w>=arr[n-1]){
          return Math.min(1+CoinExchange(arr,n,w-arr[n-1]),0+CoinExchange(arr,n-1,w));

    }else{
      return 0+CoinExchange(arr,n-1,w);
    }
    
    }

    public static int coinExchangeTab(int arr[],int  w){
         int n =arr.length;
          int dp[][]=new  int[n+1][w+1];
          dp[0][0]=0;

          for( int i=1;i<w+1;i++){
            dp[0][i]=Integer.MAX_VALUE;
          }
           for( int i=1;i<n+1;i++){
            dp[i][0]=0;
          }
          for( int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(j>=arr[n-1]){
                    dp[i][j]=Math.min(1+dp[i][j-arr[i-1]],0+dp[i-1][j]);
                }else{
                    dp[i][j]=0+dp[i-1][j];
                }
            }
          }
           return dp[n][w];
    }

    public static void main(String[] args) {
    int arr[]={1,2,5};
    int amount=11;
 System.out.println(CoinExchange(arr,arr. length, amount));
 System .out .println(coinExchangeTab(arr,amount));
    }
    
}
