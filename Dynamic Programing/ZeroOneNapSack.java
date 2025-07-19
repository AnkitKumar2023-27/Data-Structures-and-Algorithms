import java.util.Arrays;

public class ZeroOneNapSack {

    public static int ZeroOneNapSackRec(int val[],int wt[],int n,int cap){
        if(n==0||cap==0){
            return 0;
           
        }

        if(wt[n-1]<=cap){
            return Math.max((val[n-1]+ZeroOneNapSackRec(val, wt, n-1, cap-wt[n-1])),ZeroOneNapSackRec(val, wt, n-1, cap));

        }else{
            return ZeroOneNapSackRec(val, wt, n-1, cap);
        }

        

    };




 public static int ZeroOneNapSackMemo(int val[],int wt[],int n,int cap,int dp[][]){
        if(n==0||cap==0){
            return 0;
           
        }


 if( dp[n][cap]!=-1){
    return dp[n][cap];
 }

        if(wt[n-1]<=cap){
           dp[n][cap]= Math.max((val[n-1]+ZeroOneNapSackMemo(val, wt, n-1, cap-wt[n-1],dp)),ZeroOneNapSackMemo(val, wt, n-1, cap,dp));

        }else{
         dp[n][cap]= ZeroOneNapSackMemo(val, wt, n-1, cap,dp);
         

        }
         return dp[n][cap];

        

    }

     public static  int ZeroOneNapSackTab(  int val[],int wt[],int n,int cap){
        int dp[][]= new int[n+1][cap+1];
         for ( int i=0;i<n;i++){
          dp[i][0]=0;

         };
         for ( int i=0;i<cap;i++){
          dp[0][i]=0;
          
         }

    
     for( int i=1; i< n+1;i++){
        for( int j=1;j<cap+1;j++)

        if(wt[i-1]<=j){
        dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
}else{
    
    dp[i][j]=dp[i-1][j];
     }
     
    }
     return dp[n][cap];

 }
   
 


    

    
     
 

    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};

        
        int cap=7;
        int dp[][] = new int[val.length+1][cap+1];
        for (int i = 0; i < dp.length; i++) {
    Arrays.fill(dp[i], -1);
}

        System.out.println(ZeroOneNapSackRec(val, wt,val.length, cap));

        System.out.println(ZeroOneNapSackMemo(val, wt,val.length, cap,dp));

        System.out.println(ZeroOneNapSackTab(val, wt,val.length, cap));
        
    }
}

