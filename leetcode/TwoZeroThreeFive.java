public class TwoZeroThreeFive {

      public static int minimumDifference(int[] nums) {
        int maxsum =0;
        for( int i=0;i<nums.length;i++){
           maxsum+=nums[i];

        };
         int n=nums.length;

       int sum=maxsum/2;
        int dp[][]=new int[n+1][sum+1];

        for( int i=1;i<n+1;i++){
            for( int j=1;j<sum+1;j++){
                if(j>=nums[i-1]){
                    dp[i][j]=Math.max(nums[i-1]+dp[i-1][j-nums[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
         

        } 
          int sum1=dp[n][sum];
          int sum2=maxsum-sum1;
          return Math.abs(sum1-sum2);
        
    }
    public static void main(String[] args) {
      int  []nums = {-36,36};
      System.out.println(minimumDifference(nums));
        
    }
    
}
