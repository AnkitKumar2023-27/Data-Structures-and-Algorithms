public class FourEight {
    public static int MCM(int arr[], int i , int j){
        if( i==j){
            return 0;
        }
   int ans=Integer.MAX_VALUE;
         for( int k=i;k<=j-1;k++){
            int cost1=MCM(arr, i, k);
             int cost2=MCM(arr, k+1, j);
             int cost3=arr[i-1]*arr[k]*arr[j];
             int finalCost=cost1+cost3+cost2;

               ans= Math.min(ans,finalCost);

               
                     }
                      return ans;
    }
//Min Partition Sum//
public static int MinPationSum(int arr[] ){
    int n =arr.length;
    int sum=0;
    for( int i=0;i<n;i++){
        sum+=arr[i];

    }
    int w=sum/2;
    int dp[][]=new int[n+1][w+1];
    
    for( int i=0;i<w+1;i++){
        dp[0][i]=0;
    }
    for( int i=0;i<n+1;i++){
        dp[i][0]=0;
    }

   for( int i=1;i<n+1;i++){
       for(int j=1;j<w+1;j++){
        if(j>=arr[i-1]){
            dp[i][j]= Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
        }else{
            dp[i][j]=dp[i-1][j];
        }
        
       }
    
    }
      int sum1=dp[n][w];
      int sum2=sum-sum1;
      return Math.abs(sum1-sum2);
}


  public static void main(String[] args) {

     int arr[]={1,2,3,4,3};
     int n=arr.length;
     System.out.println(MCM(arr, 1, n-1));

     int arr2[]={1,6,11,5};
     System.out.println(MinPationSum(arr2));
    
  }
    
}
