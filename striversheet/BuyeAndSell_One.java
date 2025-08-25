public class BuyeAndSell_One{



    //   public static int maxProfit(int[] prices) {
        
    //      int currStock=prices[0];
    //     int profit=0;
    //     int n=prices.length-1;
    //      for( int i=1;i<=n;i++){
    //      int   Cost=prices[i]-currStock;
    //      profit=Math.max(profit, Cost);
    //      currStock=Math.min(currStock,prices[i]);

    //      }
    //       return profit;
     
    // }
// Buy and sell 11 leetcode 122
   public static int maxProfit_Two(int[] prices, int  buy, int n , int ind ) {
     if( ind==n){
         return 0;
     }
    
    int profit =0;
    if(buy==1){ 
        profit=Math.max(-prices[ind]+maxProfit_Two(prices,0,n,ind+1),0+maxProfit_Two(prices,1,n,ind+1));


    }else{
        profit=Math.max(prices[ind]+maxProfit_Two(prices,1,  n, ind+1),0+maxProfit_Two(prices,0,n,ind+1));
    }

     return profit;
    
        
    }

     public static int maxProfit(int[] prices) {
       
         
         int cap=2;
          int n= prices.length;
           int dp[][][]=new int[n+1][2][cap+1];
        if(cap==0){
            for( int i=n-1;i>=0;i--){
                for( int buy=0;buy<=1;buy++){
                    dp[i][buy][0]=0;

                }
            }

        }
        if(n==1){
            for( int buy=0;buy<=1;buy++){
                for( int j=0;j<=cap;j++){
                 dp[0][buy][j]=0;
                }
            }

        }
   
        for( int i=n-1; i>=0;i--){
            for( int buy=0;buy<=1;buy++){
                for( int j=1;j<=cap;j++){
                     if( buy==1){
                            dp[i][buy][j]=Math.max(-prices[i]+dp[i+1][0][j],0+dp[i+1][1][j]);


    }else{
        dp[i][buy][j]=Math.max(prices[i]+dp[i+1][1][j-1],0+dp[i+1][0][j]);
    }

                }

            }
        }
    
  return dp[0][1][cap]  ;    
        
}  

// Buy and sell stock with cooldowm 
public static int Maxprofit_5th( int prices[]){
    int n=prices.length;
    int dp[][]=new int[n+2][2];
    dp[n][0]=dp[n][1]=0;
     

    for(int i=n-1;i>=0;i--){
        for( int buy=0;buy<=1;buy++){
            if(buy==1){
               dp[i][buy]  =Math.max(-prices[i]+dp[i+1][0],0+dp[i+1][1]);
            }else{
                dp[i][buy]=Math.max(prices[i]+dp[i+2][1],0+dp[i+1][0]);
            }
        }
    }
    return dp[0][1];
}
    public static void main(String[] args) {
         int val[]={1,2,3,0,2};
         System.out.println(Maxprofit_5th(val));
        
         System.out.println(maxProfit(val));
         System.out.println(maxProfit_Two(val,1,val.length,0));

          System.out.println();
        
    }

}