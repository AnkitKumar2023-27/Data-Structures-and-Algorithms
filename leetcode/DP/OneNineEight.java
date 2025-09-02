public class OneNineEight {

  public static int rob(int[] nums) {

    int n=nums.length;
    if(n<2){
        return nums[0];
    }

    int dp[]=new int[n];
     dp[0]=nums[0];
       dp[1]=Math.max(nums[0], nums[1]);


        for( int i= 2; i<n;i++){
           int ans1=nums[i]+dp[i-2];
           int ans2=dp[i-1];
           dp[i]=Math.max(ans1, ans2);
        }
        return dp[n-1];
        
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,1};
        System.out.println(rob(nums));
    }
}
