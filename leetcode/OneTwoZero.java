import java.util.List;

public class OneTwoZero {

    public static int triangle(int arr[][], int i, int j, int n){
          if(i==n-1){
           return arr[n-1][j];
          };
           int doun =arr[i][j]+triangle(arr, i+1, j, n);
           int   left=arr[i][j]+triangle(arr, i+1, j+1, n);
           int ans=Math.min(doun, left);
           return ans;
    }
     public static int minimumTotal(int [][] triangle) {
         int n=triangle.length;
         int dp[][]=new int[n][n];
         for(int j=0;j<n;j++){
            dp[n-1][j]=triangle[n-1][j];
         }
         dp[0][0]=triangle[0][0];


         for( int i=n-2;i>=0;i--){
            // for (int j = 0; j <= i; j++) you can also write this  type
            for(int j=i;j>=0;j--){
                int down=triangle[i][j]+dp[i+1][j];
                int right=triangle[i][j]+dp[i+1][j+1];
                 dp[i][j]=Math.min(down,right);
            }
         }

         return dp[0][0];        
    }
// whent triangle is in list  
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int right = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, right);
            }
        }

        return dp[0][0];
    }
}


    public static void main(String[] args) {

      int  triangle[][] = {{2},{3,4},{6,5,7},{4,1,8,3}};
      System.out.println(triangle(triangle, 0, 0,triangle.length));

       System.out.println(minimumTotal(triangle));
        
    }
    
}
