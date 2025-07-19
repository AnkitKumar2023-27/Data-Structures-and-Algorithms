public class wildCardMatching {

     public static boolean wildCardMatchinTab(String s , String p){
        int n = s.length();
         int m =p.length();
         boolean  dp[][]=new boolean[n+1][m+1];
          for( int i=0;i<n+1;i++){
            if(i==0){
                dp[i][0]=true;
            }else{
                dp[i][0]=false;

            }
          }
           for( int j=1;j<m+1;j++){
            
              if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
              }  
            
          }

          for( int i=1; i<n+1;i++){
            for( int j=1;j<m+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];//if its  "_" then we remove * [i][j-1] and if s have word then remove word from s[i-1][j]
                    
                }else{
                    dp[i][j]=false;
                }
            }

          }
          Dp(dp);
          return dp[n][m];
        
     };

         public static void Dp( boolean arr[][]){
   int n = arr.length;
   int m=arr[0].length;
         for( int i=0;i<n;i++){
        for( int j=0 ;j<m;j++){

        System.out.print(arr[i][j]+" ");


    }
     System.out.println();

         }}
    public static void main(String[] args) {

        String  s="baabab";
        String pattern="***ba****ab";
        System.out.println(  wildCardMatchinTab(s, pattern));
      
        
    }
    
}
