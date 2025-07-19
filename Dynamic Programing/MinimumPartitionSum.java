

public class MinimumPartitionSum {

     public static int minPartsum( int arr[] ){

          int sum=0;
        for( int i=0; i<arr.length;i++){
            sum+=arr[i];
        }
        int w=sum/2;

        int n= arr.length;
         int dp[][]=new int[n+1][w+1];
         for(int i=0;i<n;i++){
            dp[i][0]=0;
         };
          for(int i=1;i<=w;i++){
            dp[0][i]=0;
         };

        for( int i=1;i<n+1;i++ ){
            for(int j=1;j<w+1;j++){
                if(arr[i-1]<=j){
                     dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
               
            }
        }   
        
        int sum1= dp[n][w];
         int sum2=sum-sum1;
         return Math.abs(sum1-sum2);



     }


    public static void main(String[] args) {
        int arr[]={1,6,11,5  };
       System.out.println(minPartsum(arr));
        
    }
    
}
