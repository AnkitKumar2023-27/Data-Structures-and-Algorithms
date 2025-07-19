public class wordMaker {

    public static int wordmker(String str1,String str2){
         int n= str1.length();
         int m=str2.length();
          int dp[][]= new int[n+1][m+1];
          for( int i=0;i<n+1;i++){
            dp[i][0]=i;
          }
          for( int i=0;i<n+1;i++){
            dp[0][i]=i;
        
          }

           for( int i=1;i<n+1;i++){
            for( int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int add=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int rep=dp[i-1][j-1]+1;

                    dp[i][j]=Math.min(add,Math.min(del, rep));
                }
            }
          }


          return dp[n][m];

        
    }
   public static void main(String[] args) {
    String str1="intention";
    String str2="execution";
    System.out.println(wordmker(str1, str2));
    
   } 
    
}
