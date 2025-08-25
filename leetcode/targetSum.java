

public class targetSum {

    public static boolean TargetSubsetsum( int arr[], int n, int s){
        if (s==0){
            return true; 
        }
        if(n==0){
            return false;
        }
        if(n==0&&s==0){
            return true;
        }
         

        if (s>=arr[n-1]) {
          
        return TargetSubsetsum(arr, n-1, s-arr[n-1])||TargetSubsetsum(arr, n-1, s);
        }else{
            return  TargetSubsetsum(arr, n-1, s);
        }
       
        
    };
public static boolean targetSumTab( int arr[],int w){
    int n =arr.length;
    
      boolean dp[][]= new  boolean[n+1][w+1];
      dp[0][0]=true;
      for( int i=1; i<n+1;i++){
        dp[i][0]=true;
      };
      for( int i=1; i<w+1;i++){
        dp[0][i]=false;
      }
      for( int i=1; i<n+1;i++){
        for( int j=1;j<w+1;j++){
          if(j>=arr[i-1]&&dp[i-1][j-arr[i-1]]||dp[i-1][j]==true){
            dp[i][j]=true;
                  }
                  else{
                    dp[i][j]=false;
                  }
        }
      }
      return dp[n][w];
}

public static int TotalsubsetwithsumK( int arr[], int w){
    int n=arr.length;
    int dp[][] =new int[n+1][w+1];
    dp[0][0]=1;
    for(int i=1;i<w+1;i++){
        dp[0][i]=0;
    }
     for(int i=1;i<n+1;i++){
        dp[i][0]=1;
    };
     for(int i=1;i<n+1;i++){
       for( int j=1;j<w+1;j++){
         if(j>=arr[i-1]){
            dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
         }else{
             dp[i][j]=dp[i-1][j];
         }
         
        
       }
    }
     return dp[n][w];
}
public static int helper(int arr[], int differ){
     int sum=0;
    for(int num:arr){
        sum+=num;
    };
     int target=(sum-differ)/2;

     if((sum-differ)<0||target!=Math.abs(target)){
         return 0;
     }
     return TotalsubsetwithsumK(arr, target);
    
}


    public static void main(String[] args) {
   int  arr[]={1,4,2,3,1};
   int s=9;
   System.out.println(TargetSubsetsum(arr, arr.length, s));


    System.out.println(targetSumTab(arr, s));
     System.out.println(TotalsubsetwithsumK(arr, s));

       int arr2[] = {5,2,6,4};

  int d=3;

  
  System.out.println(helper(arr2, d));
        
    }
}