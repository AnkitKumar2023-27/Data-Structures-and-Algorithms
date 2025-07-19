public class rodCutting {


     public static int rodCuttingtab(int length[],int price[],int total,int n){
        int dp[][] = new int[n+1][total+1];
            for( int i=0; i<n+1;i++){
                dp[i][0]=0;

            }


         for( int i=1; i<n+1;i++){
            for( int j=1;j<total+1;j++){
                if(length[i-1]<=j){
                    dp[i][j]=Math.max( price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);

                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
            
        }
    Dp(dp);
  return dp[n][total];
     }

       public static void Dp( int arr[][]){
   int n = arr.length;
   int m=arr[0].length;
         for( int i=0;i<n;i++){
        for( int j=0 ;j<m;j++){

        System.out.print(arr[i][j]+" ");


    }
     System.out.println();

         }}

    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int n = length.length;

         int rodLength=8;
         
         System.out.println(rodCuttingtab(length, price,rodLength, n ) );

       
       
    };



    
}
