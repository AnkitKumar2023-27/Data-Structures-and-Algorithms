

public class SixFour {

    public static int MinSum( int arr[][], int m, int n){
        if(m==0&&n==0){
            return arr[0][0];

        }
        if(m<0||n<0){
            return Integer.MAX_VALUE;
        }


        

       int  PathSum=  arr[m][n]+Math.min(MinSum(arr, m-1, n),MinSum(arr, m, n-1));
        return PathSum;

    }

    
    public static int MinSumTab( int arr[][], int m, int n){
        if(m==0&&n==0){
            return arr[0][0];

        }
        if(m<0||n<0){
            return Integer.MAX_VALUE;
        }


        

       int  PathSum=  arr[m][n]+Math.min(MinSum(arr, m-1, n),MinSum(arr, m, n-1));
        return PathSum;

    }

public static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int dp[][] = new int[m][n];

    for (int i = 0; i < m; i++) {
        
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) {
                dp[0][0] = grid[0][0];
            } else {
              int up=(i>0)?grid[i][j]+dp[i-1][j]:Integer.MAX_VALUE;
              int left=(j>0)?grid[i][j]+dp[i][j-1]:Integer.MAX_VALUE;
              dp[i][j]=Math.min(up, left);
            }
        }
        
    }
    return dp[m-1][n-1];
}

    public static void main(String[] args) {
        int grid[][]= {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(MinSum(grid, grid.length-1,grid[0].length-1));
         System.out.println(minPathSum(grid));
        
    }
}
