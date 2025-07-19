
import java.util.Arrays;

public  class DpBasic {

    public static int fib(int n){
        if(n==0||n==1){
            return n;
        }

         return fib(n-1)+fib(n-2);
    }
    
    
    //Fib using Memoization
 public static int fibMemo(int n){
        if(n==0||n==1){
            return n;
        }
int dp[]=new int[n+1];
Arrays.fill(dp, -1);


if(dp[n]!=-1){
    return  dp[n];
}else{
   dp[n] = fib(n-1)+fib(n-2);
}

return dp[n];
    }

//Fib using Tabulation 


 public static int fibTab(int n){
   
int dp[]=new int[n+1];
Arrays.fill(dp, -1);

dp[0]=0;
dp[1]=1;

if(dp[n]!=-1){
      dp[n]= fib(n-1)+fib(n-2);
}
for(int i=2;i<=n;i++){

       dp[i]=dp[i-1]+dp[i-2];
    }

return dp[n];
    }


     public static void main(String[] args) {
   System.out.println(fib(4));
      System.out.println(fibMemo(4));

      System.out.println(fibTab(4));
        
        
     }
}