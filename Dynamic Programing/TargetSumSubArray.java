public class TargetSumSubArray {


     public static boolean targetSum( int arr[], int cap){
        boolean dp[][]=new boolean[arr.length+1][cap+1];

         for( int i=0; i<arr.length+1;i++){
            dp[i][0]=true;
         }
         for( int i=1; i<arr.length+1;i++){
            dp[i][0]=false;
         }
        for( int i=1; i<arr.length+1;i++){
            for( int j=1; j< cap+1;j++){
                if(arr[i-1]<j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }

            }}

                return dp[arr.length][cap];
            
        
     }
    public static void main(String[] args) {

        
        int[] arr = {3, 34, 4, 12, 5, 2};
        int cap = 9;
        boolean result = targetSum(arr, cap);
        System.out.println("Subset with sum " + cap + " exists: " + result);

        
    }
    
}
