import java.util.Arrays;

public class MCM {

    public static int MCM1( int arr[ ], int i , int j, int dp[][]){
        
        if( i==j){
             return 0;
        }


        if( dp[i][j]!=-1){
            return dp[i][j];
        }
    int ans=Integer.MAX_VALUE;
        for( int k=i;k<=j-1;k++){
         int   sum1=MCM1(arr, i, k,dp);
         int    sum2=MCM1(arr,k+1,j,dp);
          int   TotalSum=arr[i-1]*arr[k]*arr[j];
          
          int finamCost=sum1+sum2+TotalSum;
              ans=Math.min(ans,finamCost);
        } 
        return dp[i][j]=ans;
     
    }

    public static void main(String[] args) {

        int arr[]={1,2,3,4,3};
         int n=arr.length;
         int dp[][]=new int[n+1][n+1];

         for( int i=0;i<n+1;i++){
            Arrays.fill(dp[i], -1);
         }
        System.out.println(MCM1(arr, 1,arr.length-1,dp));
        
    }
    
}
