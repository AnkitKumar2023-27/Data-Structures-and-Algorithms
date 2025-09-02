public class FourOneSix {

    
    public static boolean canPartition(int[] nums) {
        int n=nums.length; 
         int sum=0;
         for( int num :nums){
            sum+=num;
         }
          int w=sum/2;
          int dp[][]=new int[n+1][w+1];
          for( int i=0;i<n+1;i++){
            dp[i][0]=0;
          }
           for( int i=0;i<w+1;i++){
            dp[0][i]=0;
          }

           for( int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
             if(j>=nums[i-1]){
                dp[i][j]=Math.max(nums[i-1]+dp[i-1][j-nums[i-1]], dp[i-1][j]);
             }else{
                dp[i][j]= dp[i-1][j];

             }

            }
          }
    int sum1=sum-dp[n][w];
    int sum2=sum-sum1;
    if(sum1==sum2){
        return  true;

    }else{
        return false;
    }

    
    }

     


    public static void main(String[] args) {
       int nums []= {1,5,11,5};

     
       System.out.println(canPartition(nums));
    }
    
}
