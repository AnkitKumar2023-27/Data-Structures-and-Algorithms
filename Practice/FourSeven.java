import java.util.Arrays;

public class FourSeven {

    public static boolean WildCardMaching( String s, String p){

     int m=s.length();
     int n=p.length();

     
     boolean dp[][]=new boolean[m+1][n+1];
     dp[0][0]=true;

       for( int i =1 ; i<m+1;i++){
                dp[i][0]=false;

            }
           
            
            
        for( int j=1;j<n+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }

     for( int i =1; i<m+1;i++){
              for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){

                    dp[i][j]=dp[i][j-1]||dp[i-1][j];


                }else{
                    dp[i][j]=false;
                }
              }

            }return dp[m][n];



    }

    public static int catlansAlgo(int n ,int dp[]){

        if(n==1||n==0){
            return 1;
        }
       if(dp[n]!=-1){
         return dp[n];
       }
     int ans=0;
       

       for( int i=0; i <=n-1;i++){
        ans+=catlansAlgo(i, dp)*catlansAlgo(n-i-1, dp);
       
      
       }
       dp[n]=ans;
       return dp[n];


    }

    public static int catlansTab(int n){

        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
           

         for( int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
         dp[i]+=dp[j]*dp[i-j-1];
            }
         }
            return dp[n];
    }

    public static void main (String args[]){

        String s="Akr";
        String p="*Ak?**";
        System.out.println(WildCardMaching(s, p));

        int dp[]=new int[5+1];

        Arrays.fill(dp,-1);
       

        System.out.println( catlansAlgo(5,dp));

        System.out.println(catlansTab(5));

    }
    
}
