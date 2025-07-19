public class CoinExchange {

    public static int coinChnage(int coin[], int n ,int total){
          int dp[][]=new int[n+1][total+1];

    for( int i=0 ; i<n+1;i++){
        dp[i][0]=1;
    }; 
    for( int i=1 ; i<total+1;i++){
        dp[0][i]=0;
    };
     for( int i=1;i<n+1;i++){
        for( int j=1 ;j<total+1;j++){
            if(coin[i-1]<=j){ 
                dp[i][j]=dp[i][j-coin[i-1]]+dp[i-1][j];
            } else{
                dp[i][j]=dp[i-1][j];
            }

        }
     }
   Dp(dp);
  System.out.println();

return dp[n][total];
  
    }

    public static void Dp( int arr[][]){
   int n = arr.length;
   int m=arr[0].length;
         for( int i=0;i<n;i++){
        for( int j=0 ;j<m;j++){

        System.out.print(arr[i][j]+" ");


    }
     System.out.println();

         }}
    public static void main(String[] args) {
        int coin[]={2,5,3,6};
        int sum=10;

         int n=coin.length;
        System.out.println(coinChnage(coin, n, sum));
        
    }
    
}
