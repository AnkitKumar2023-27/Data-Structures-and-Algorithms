import java.util.Arrays;

public class Zero_One_KS_DP {
//memoization 
    public static int ClimbStair_Memo( int n, int ways[]){
         if( n==0){
            return 1;
         }
          if( n<1){
             return 0;
          }
         if(ways[n]!=-1){
            return ways[n];
         }
         ways[n]=ClimbStair_Memo(n-1, ways)+ClimbStair_Memo(n-2,ways);  
         return ways[n];

    };

    //tabulation
    public static int ClimbStatir_Tab( int n){

        int  dp[]=new int[n+1];
        dp[0]=1;
        for ( int i=1; i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;
            }
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
         return dp[n];

    }
//ZERO ONE  KNAPSACK 
    public static  int Zero_Memo( int val[], int wt[], int  dp[][], int W,int n){
        
        if( W==0||n==0){
             return 0;
        }
        if(dp[n][W]!=-1){
             return dp[n][W];
        };
         if(W>=wt[n-1]){
           return dp[n][W]=Math.max(( val[n-1]+Zero_Memo(val, wt, dp, W-wt[n-1],n-1) ),Zero_Memo(val, wt, dp, W,n-1));
          
          
         
          }
          else{
          return  dp[n][W]= Zero_Memo(val, wt, dp, W,n-1);

          }

    };


    public static int Zero_Tab( int wt[], int val[],int W){
        int n=val.length;
        int dp[][]= new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
             
                dp[i][0]=0;
             }
             
              for(int j=0;j<W+1;j++){
                dp[0][j]=0;
              }

  for(int i=1;i<n+1;i++){
    for(int j=1;j<W+1;j++){
        if(j>=wt[i-1]){
         dp[i][j]=Math.max((val[i-1]+dp[i-1][j-wt[i-1]]), dp[i-1][j]);

        }
           else{
                 dp[i][j]=dp[i-1][j];
           }    
             }
             }
             return dp[n][W];
 }
// FIX VALUE Target Sum


public static  boolean TargetSum(int val[],int W){
     int n = val.length;
   boolean dp[][]=new boolean[n+1][W+1];
    for( int i=0;i<=n;i++){
        dp[i][0]=true;
    }
      
      for( int i=1;i<n+1;i++){
       for( int j=1; j<W+1;j++){
        if(j>=val[i-1]&&dp[i-1][j-val[i-1]]==true){
            dp[i][j]=true;
        }else if(dp[i-1][j]==true){
            dp[i][j]=true;
        }
       }



    }
    print(dp);
    return dp[n][W];

}

public static void print(boolean dp[][]){
    
    for(int i=0;i<dp.length;i++){
    for(int j=0;j<dp[0].length;j++){
        System.out.print(dp[i][j] +" ");
    
}
System.out.println();

}
}
// unbounded knapsack

 public static int Unbound_Tab( int val[], int wt[],int  W){
     int n = val.length;
     int dp[][]= new int[n+1][W+1];
     for( int i=0; i<=n; i++){
        dp[i][0]=0;
     }
     for( int i=0; i<=W; i++){
        dp[0][i]=0;
     }

     
 for( int i =1; i<n+1;i++){
    for( int j=1; j<W+1;j++){
        if(j>=wt[i-1]){
            dp[i][j]=Math.max((val[i-1]+dp[i][j-wt[i-1]]),dp[i-1][j]);
        }else{
            dp[i][j]=dp[i-1][j];
        }
    }

 }
 return dp[n][W];

 }

    public static void main(String args[]){
         int n=5;
        int ways[]= new int[n+1];
        Arrays.fill(ways,-1);
       
          System.out.println(  ClimbStair_Memo(n, ways));
           System.out.println();

          System.out.println(ClimbStatir_Tab(n));


          int val[]={15,14,10,45,30};
          int wt[]={2,5,1,3,4};
           int m=val.length; int W=7;
          int dp[][]= new int[m+1][W+1];
          for ( int i=0; i<=m;i++){
            
            Arrays.fill(dp[i],-1);
            }
          
          
            System.out.println(Zero_Memo(val, wt, dp, W, m));


            System.out.println();
            System.out.println(Zero_Tab(wt,val,W));

          
 // FIX VALUES 

 int nubers[]={4,2,7,1,3};
 int TargetSum=10;
   System.out.println();
 System.out.println( "Is Target Sum Found ="+TargetSum(nubers,TargetSum));
 //Unbounded  knapsack

        System.out.println(Unbound_Tab(val, wt, W));
    }   
}
