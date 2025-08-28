
import java.util.Arrays;

public class OneFiveFourSeven {
 
    public static int MaxStickPart( int i, int j, int arr[]){
        if(i>j){
            return 0;
        };
         int minCost=Integer.MAX_VALUE;

       for( int k=i;k<=j;k++){
            int cost=(arr[j+1]-arr[i-1])+MaxStickPart(i, k-1, arr)+MaxStickPart(k+1, j, arr);
          
            minCost=Math.min(cost, minCost);
         }
         return minCost;
      
    }
    public static int MaxStickPartMemo( int i, int j, int arr[],int dp[][]){
        if(i>j){
            return 0;
        };
         if( dp[i][j]!=-1){
            return dp[i][j];
         }
         int minCost=Integer.MAX_VALUE;

       for( int k=i;k<=j;k++){
            int cost=(arr[j+1]-arr[i-1])+MaxStickPartMemo(i, k-1, arr,dp)+MaxStickPartMemo(k+1, j, arr,dp);
          
            minCost=Math.min(cost, minCost);
            
         }
         return dp[i][j]=minCost;
      
    }
     public static int minCost(int n, int[] cuts) {

         int m=cuts.length;
    
      int newArr[]=new int[cuts.length+2] ;
        newArr[0]=0;
        newArr[newArr.length-1]=n;
        for( int i=0; i<=cuts.length-1;i++){
            newArr[i+1]=cuts[i];

        }
        Arrays.sort(newArr);
         
         int dp[][]=new int[m+2][m+2];
         for(int i=0;i<m+2;i++){
            Arrays.fill(dp[i], -1);
         }
         return   MaxStickPartMemo(1, m, newArr, dp);
    }

    public static void main(String[] args) {
      
        int arr[]={1,3,4,5};
        int n=7; 
        int newArr[]=new int[arr.length+2] ;
        newArr[0]=0;
        newArr[newArr.length-1]=n;
        for( int i=0; i<=arr.length-1;i++){
            newArr[i+1]=arr[i];

        }
        Arrays.sort(newArr);
         int m=arr.length;
         int dp[][]=new int[m+2][m+2];
         for(int i=0;i<m+2;i++){
            Arrays.fill(dp[i], -1);
         }
         System.out.println(MaxStickPart(1, arr.length, newArr));

        System.out.println(MaxStickPartMemo(1, m, newArr, dp));

        System.out.println(minCost(n,arr));
       
    }


    
}
