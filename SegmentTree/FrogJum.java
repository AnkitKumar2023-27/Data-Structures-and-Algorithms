public class FrogJum {

    public static int FrogJump(int index, int arr[]){
        if(index==0){
            return 0;
            


        }
          int Jum1=FrogJump(index-1, arr)+Math.abs(arr[index]-arr[index-1]);
          int jump2=Integer.MAX_VALUE;
          if(index>1){
              jump2=FrogJump(index-2, arr)+Math.abs(arr[index]-arr[index-2]);
          }
        
          
           return Math.min( Jum1,jump2);
         
    }

    public static int frogjumpTab(int arr[]){
        int n=arr.length;
        int dp[]=new int[n];
        dp[0]=0;


        for( int i=1; i<n;i++){
            int jump1=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
             int jump2=Integer.MAX_VALUE;
             if( i>1){
                jump2=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
             }

              dp[i]=Math.min(jump1, jump2);
        }
        return dp[n-1];
    }
     public static void main(String[] args) {
        
        int arr[]={30,10,60,10,60,50};
        int n=arr.length;
        System.out.println(FrogJump(n-1,arr));
         System.out.println(frogjumpTab(arr));
     }
    
}
