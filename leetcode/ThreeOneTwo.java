public class ThreeOneTwo {
     public static int maxCoins(int i, int j,int[] nums) {
        if(i>j){
            return 0;

        };
         int max=0;
        for( int k=i;k<=j;k++){
          int   cost=nums[i-1]*nums[k]*nums[j+1]+maxCoins(i, k-1, nums)+maxCoins(k+1, j, nums);
           max= Math.max(max, cost);
        }
      return max;
        
    }
// memoization ''
  
    public  static int maxCoinsMemo(int[] arr) {
        int n = arr.length;

        
        int nums[] = new int[n + 2];
        nums[0] = 1;
        nums[nums.length - 1] = 1;
        for (int i = 0; i < n; i++) {
            nums[i + 1] = arr[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) java.util.Arrays.fill(row, -1);

        return solve(1, n, nums, dp);
    }

    private  static int solve(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int max = 0;
        for (int k = i; k <= j; k++) {
            int cost = nums[i - 1] * nums[k] * nums[j + 1]
                     + solve(i, k - 1, nums, dp)
                     + solve(k + 1, j, nums, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }


    public static void main(String[] args) {
         int arr[]={3,1,5,8};
          int n=arr.length;
         int nums[]=new int[n+2];
         nums[0]=1;
         nums[nums.length-1]=1;
         for( int i=0;i<n;i++){
            nums[i+1]=arr[i];

         };
        //  for( int i=0;i<=n+1;i++){
        //    System.out.print(nums[i]+" ");

        //  };
         

         System.out.println(maxCoins(1,n,nums));

          System.out.println(maxCoinsMemo( arr));
        
    }
    
}
