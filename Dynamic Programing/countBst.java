public class countBst {
      public static  int CountBST(int n){
          
          int dp[]=new int[n+1];
          dp[0]=dp[1]=1;
          for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
          }
          return dp[n];
      }


    public static void main(String[] args) {
         int arr[]={10,20,30};
         

         System.out.println(CountBST(arr.length));
        

    }


    
    
}
