import java.util.Arrays;

public class totalpath {


    public static int ways(int dp[][],int i,int j){

        if(i==0&&j==0){
            return 1;
        }
         if(i<0||j<0){
            return 0;
         }
         if(dp[i][j]!=-1){
            return dp[i][j];
         }
         int w1=ways(dp,i-1,j);
         int w2=ways(dp,i,j-1);
          dp[i][j]=w1+w2;

       return dp[i][j];

    }

    public static int waystab(int m, int n) {
    int dp[][] = new int[m][n];

    // Initialize first row and first column
    for (int i = 0; i < m; i++) {
        dp[i][0] = 1; // Only 1 way to move down
    }
    for (int j = 0; j < n; j++) {
        dp[0][j] = 1; // Only 1 way to move right
    }

    // Fill rest of the table
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    return dp[m - 1][n - 1];
}

// grid on  unique path 
public static int Uniquepath( int arr[][]){
      int m=arr.length;
       int n=arr[0].length;

    int dp[][]=new int[m][n];
      if (arr[0][0] == 1) return 0;
    dp[0][0]=1;
     for( int i=1 ;i<m;i++){
        if(arr[i][0]==1){
            dp[i][0]=0;}else{
                dp[i][0]=1; 
            }
     
     }
     for( int i=1 ;i<n;i++){
        if(arr[0][i]==1){
            dp[0][i]=0;
        }else{
             dp[0][i]=1;
        }
     
     };
  
     for( int i=1;i<m;i++){
    for( int j=1;j<n;j++){
     if(arr[i][j]==1){
      dp[i][j]=0;
     }
     else{
       dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     }


    }
  
     
     }

  return dp[m-1][n-1];
     

}
    public static void main(String[] args) {

         int m=2; 
         int n = 4;
         int dp[][]= new int[m][n];
         for( int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
         }

         System.out.println(ways(dp,m-1,n-1));
         System.out.println(waystab(m, n));

      int   arr[][] = {{0,1},{0,0}};
       
         System.out.println(Uniquepath(arr));
        
    }
    
}
