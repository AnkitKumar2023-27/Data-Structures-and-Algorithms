import java.util.Arrays;

public class minArrayJump {

     public static int minArraysJump( int arr[]){
        int n = arr.length;
         int dp[]=new int[n];
       
         dp[n-1]=0;
         int ans=Integer.MAX_VALUE;
         for( int i=n-1;i>=0;i--){
            int steps=arr[i];
            
            for( int j=i+1;j<=i+steps&& j<n;j++){
                ans=Math.min(ans, dp[j]+1);
           
         }
         if ( ans!=Integer.MAX_VALUE){
              dp[i]=ans;
         } 
       
       } 
          return dp[0] ;

     
         } 



    public static void main(String[] args) {

        int arr[]={2,3,1,1,4 };
        System.out.println(minArraysJump(arr));
        
    }  
}
