import java.util.Arrays;
import java.util.TreeSet;

public class DP_Four_ {
//recursion Lcs
    public static int  lcs( String str1,String str2, int m , int n ){
        if( m==0||n==0){
             return 0;
        }
        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return lcs(str1, str2, m-1, n-1)+1;
        }else{
          int  ans1=lcs(str1, str2, m-1, n)   ;
          int ans2=lcs(str1, str2, m, n-1);
          return Math.max(ans1, ans2);
        }
    }

   // Memoization
 public static int  lcs_Memo( String str1,String str2, int m , int n, int dp[][] ){
        if( m==0||n==0){
             return 0;
        }
      if(dp[m][n]!=-1){
        return dp[m][n];
      }

        if(str1.charAt(m-1)==str2.charAt(n-1)){
            dp[m][n]= lcs_Memo(str1, str2, m-1, n-1,dp)+1;
        }else{
          int  ans1=lcs_Memo(str1, str2, m-1, n,dp)   ;
          int ans2=lcs_Memo(str1, str2, m, n-1,dp);
           dp[m][n]=  Math.max(ans1, ans2);
        }
        return dp[m][n];
    }

    //lcs tabulatuon 
public static int lcs_Tabu( String str1, String str2){
     int m = str1. length();
      int n =str2.length();

    int dp[][]=new int[n+1][m+1];
for(int i =0 ; i<m+1;i++){
    dp[i][0]=0;
   }
  for( int j =0;j< n+1;j++){
        dp[0][j]=0;
     }

    for(int i =1 ; i<m+1;i++){
     for( int j =1;j< n+1;j++){
        if( str1. charAt(i-1)==str2.charAt(j-1)){
            dp[i][j]=dp[i-1][j-1]+1;
        }else{
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
        
        
     }  } 

      return dp[m][n];

    
}
// longest common Substring 

public static int lcSubstring( String str1, String str2   ){
    int m =str1.length();
    int n=str2.length();
    int ans = 0;
    int dp[][]=new int[m+1][n+1];
    for ( int i =0; i<m+1;i++){
        for( int j=0; j<n+1;j++){
             dp[i][j]=0;
        }
    }
      for ( int i =1; i<m+1;i++){
        for( int j=1; j<n+1;j++){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1]+1;
                ans=Math.max(ans, dp[i][j]);

            }else{
                dp[i][j]=0;
            }
        }
    }
     return ans;
    

    }


 // Increasing order subsequence
 
 public static int  IOS( int arr1[], int arr2[]){

     int m= arr1.length;
      int n=arr2.length;
      int dp[][]=new int[m+1][n+1];
      for(int i=0; i< m+1;i++){
        for( int j=0;j<m+1;j++){
            dp[i][0]=0;
            dp[0][j]=0;

        }

      };
         for(int i=1; i< m+1;i++){
        for( int j=1;j<m+1;j++){
            if(arr1[i-1]==arr2[j-1]){
                dp[i][j]=dp[i-1][j-1]+1;
            }else{
                dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }

        }

      }
       return dp[m][n];
    


 }

//edit Distance 
 public static int EditDistance(String str1, String str2 ){
    int m= str1.length(); 
     int n = str2. length();
     int dp[][]=new int[m+1][n+1];
     for ( int i=0; i<n+1;i++){
         for( int j=0;j<m+1;j++){
            if(i==0){
                dp[i][j]=j;
            }
            if(j==0){
                dp[i][j]=i;

            }
         }
     }
       for ( int i=1; i<n+1;i++){
         for( int j=1;j<m+1;j++){
          if(str1.charAt(i-1)==str2.charAt(j-1)){
              dp[i][j]=dp[i-1][j-1];

          }else{
            dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
          }
         }
     }
      return dp[m][n];
 }
// other metod
//edit distance  without replacement Algo
public static int EditDistance2(String str1,String str2){
    int m = str1.length();
     int n=str2.length();
      int dp[][]= new int[m+1][n+1];
      for ( int i=0; i<n+1;i++){
         for( int j=0;j<m+1;j++){
            if(i==0){
                dp[i][j]=j;
            }
            if(j==0){
                dp[i][j]=i;

            }
         }
     } 
      for ( int i=1; i<n+1;i++){
         for( int j=1;j<m+1;j++){
          if(str1.charAt(i-1)==str2.charAt(j-1)){
              dp[i][j]=dp[i-1][j-1];

          }else{
            dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
          }
         }
     }
      return dp[m][n]; 

}

 public static int StringConversion(String str1, String str2){
    int LCS=lcs_Tabu(str1,str2);
    System.out.println(LCS);;
    int m =str1.length();
     int n=str2.length();
    

       int TotalDeleteOpration=m-LCS;
       int TotalAddOpration=n-LCS;
       int TotalOPrationInStrinConversion=TotalAddOpration+TotalDeleteOpration;
       return TotalOPrationInStrinConversion;
 }

public static void main(String[] args) {
    String str1="abcdge";
    String  str2="abedge";
    int m= str1.length();
    int n = str2.length();
   System.out.println(lcs(str1, str2, m, n));
   // memo
       int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

  
        System.out.println(lcs_Memo(str1, str2, m, n, dp));

        System.out.println();
        System.out.println(lcs_Tabu(str1,str2));

        System.out.println("Longets comon Substring");
        System.out.println(lcSubstring(str1, str2));

         int arr1[]={50,3,10,7,40,80};
         TreeSet<Integer>arr2=new TreeSet<>();
          for(Integer I1:arr1){
            arr2.add(I1);


          }

           int arr22[]=new int[arr2.size()];


           int i=0;
     for(Integer num:arr2){
        arr22[i]=num;
        i++;

     }
  System.out.println(IOS(arr1,arr22));
  System.out.println();
  System.out.println("Edit Distance Problem");

  String str3="intention";
  String str4="exicution";
  System.out.println(EditDistance(str3, str4));

  System.out.println("Edit Distance Withput Replacement ");

  
  System.out.println(EditDistance2(str3,str4));
    System.out.println(" Strint Conversion Example ");
    System.out.println(StringConversion(str3,str4));
}
 

    
    
}
