public class unboudedKnapsack {



public static  int UnboundedKnapSack( int wt[],int val[], int cap, int n){
    int dp[][]=new int[n+1][cap+1];
    for( int i=0 ; i<n+1;i++){
        dp[i][0]=0;
    }; 
    for( int i=0 ; i<cap+1;i++){
        dp[0][i]=0;
    };
     for( int i=1;i<n+1;i++){
        for( int j=1 ;j<cap+1;j++){
            if(wt[i-1]<=j){
                dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
            } else{
                dp[i][j]=dp[i-1][j];
            }

        }
     }
return dp[n][cap];
}
public static void main(String[] args) {
    int val[]={15,14,10,45,30};
    int wt[]={2,5,1,3,4};

    int n=val.length;
     int cap=7;
   System.out.println(UnboundedKnapSack(wt,val,cap,n)); //100
}

    
    
}
