import java.util.*;

public class Inc_S {
    public static int Long_Inc_Str(int arr[],int ind , int pre){
         int n = arr.length;
        if(ind==n){
            return 0;
        }

        if(pre==-1||arr[ind]>arr[pre]){
            return Math.max(1+Long_Inc_Str(arr, ind+1, ind),0+Long_Inc_Str(arr, ind+1, pre));
        }else{
            return Long_Inc_Str(arr, ind+1, pre);
        }
    
     
    }
//TABULATION METHOD
public static int lengthOfLIS(int[] nums) {
      
         int n=nums.length;
          int dp[][]=new int[n+1][n+1];
         for(int i=0;i<=n;i++){
            dp[n][i]=0;
         }

         for(int i=n-1;i>=0;i--){
             for (int pre = i - 1; pre >= -1; pre--){
                if(pre==-1||nums[i]>nums[pre]){
                    dp[i][pre+1]=Math.max(1+dp[i+1][i+1],dp[i+1][pre+1]);
                }else{
                    dp[i][pre+1]=0+dp[i+1][pre+1];
                }
            }
         }
       return dp[0][0] ;
    }

     public static int Long_Inc_Str_memo(int arr[],int ind , int pre){
         int n = arr.length;
        if(ind==n){
            return 0;
        }

        if(pre==-1||arr[ind]>arr[pre]){
            return Math.max(1+Long_Inc_Str(arr, ind+1, ind),0+Long_Inc_Str(arr, ind+1, pre));
        }else{
            return Long_Inc_Str(arr, ind+1, pre);
        }
     }
     
// 2ND METHOD WHICH  LESS TIME COPLEXITY
public int lengthOfLIS2nd(int[] nums) {
        int n = nums.length;
         int dp[]=new int[n];
        Arrays.fill(dp,1);
         int max=1;
        for( int i=0 ;i<n;i++){
            for(int pre=0;pre<i;pre++){
                if(nums[pre]<nums[i]){
                    dp[i]=Math.max(dp[i],1+dp[pre]);
                }
            }
            max=Math.max(max, dp[i]);
        }
         return max;
     }


//  USING 2ND METHOD HOW TO PRINT LONGES INCREASING STRING VERY IMPORTENT     
public static void PrintLIS( int nums[]){
        int n=nums.length;
         int dp []= new int[n];
         Arrays.fill(dp,1) ;
         int result[]=new int [n];
         Arrays.fill(result,-1);
    int Max=1;
    int LastIndex=0;

         for( int i=0;i<n;i++ ){
            for( int prev=0;prev<i;prev++){
                if(nums[i]>nums[prev]){
                    dp[i]=Math.max(dp[i],1+dp[prev]);
                    result[i]=prev;

                }
            }
           if (dp[i] > Max) {
    Max = dp[i];
    LastIndex = i;
}
         }
         ArrayList<Integer>list=new ArrayList<>();
         while(LastIndex!=-1){
            list.add(nums[LastIndex]);
            LastIndex=result[LastIndex];
            

         }
         Collections.reverse(list);
         System.out.println("Length of Max LIS = "+Max);
         System.out.println("LIS = " +list);
     }

// USING 2ND METHOD OF LONGEST INSING STRING WE GOING TO PRINT LONEST DIBISBLE SUBSET     

 public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
         int dp []= new int[n];
         Arrays.fill(dp,1) ;
         int result[]=new int [n];
         Arrays.fill(result,-1);
    int Max=1;
    int LastIndex=0;

         for( int i=0;i<n;i++ ){
            for( int prev=0;prev<i;prev++){
              if (nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]) {
    dp[i] = dp[prev] + 1;
    result[i] = prev;
}

            }
         if (dp[i] > Max) {
    Max = dp[i];
    LastIndex = i;
}  
         }
         ArrayList<Integer>list=new ArrayList<>();
         while(LastIndex!=-1){
            list.add(nums[LastIndex]);
            LastIndex=result[LastIndex];
            

         }
         Collections.reverse(list);
        //  System.out.println("Length of Max LIS = "+Max);
        return list;
     }
// LONGEST STRING CHAIN IT CAN ALSO SOLVE BY THE HASHMAP
  public static int LongestSringChin(String arr[]){
     int n=arr.length;
     Arrays.sort(arr,(a,b)->a.length()-b.length());
     int dp[]=new int[n];
     Arrays.fill(dp,1);
     int max=1;
     for( int i=0;i<n;i++){
        for( int pre=0;pre<i;pre++){
         if(comparePossible(arr[i],arr[pre])&&dp[pre]+1>dp[i]){
            dp[i]=dp[pre]+1;

         }

        }
        if(dp[i]>max){
            max=dp[i];
        }
     }
     return max;
  } 

  public static boolean comparePossible(String s1,String s2){
    if(s1.length()!=s2.length()+1){
        return false;
    }
    int i=0;
     int j=0;
     while(i<s1.length()&&j<s2.length()){
        if(s1.charAt(i)==s2.charAt(j)){
            i++;
            j++;
        }else{
            i++;
        }
     }

    return j==s2.length();
      
  }
  /// longest  bitcoin subsequence
  public static int MaxBitconicSub( int arr[]){
    int n =arr.length;
    int dp1[]=new int[n];
    Arrays.fill(dp1,1);
    for( int i=0;i<n;i++){
        for( int pre=0;pre<i;pre++){
            if(arr[i]>arr[pre]&& dp1[pre]+1>dp1[i]){
                dp1[i]=dp1[pre]+1;
            }
        }

    }

    int dp2[]=new int[n];
    Arrays.fill(dp2,1);


     for( int i=n-1;i>=0;i--){
        for( int j=n-1;j>i;j--){
            if(arr[j]<arr[i]&&dp2[j]+1>dp2[i]){
                dp2[i]=dp2[j]+1;
            }
        }
     }
      int max=0;
      for( int i=0;i<n;i++){
         max=Math.max(max,(dp1[i]+dp2[i]-1));
      }
     return max;
}
//Count total no of LIS  public int findNumberOfLIS(int[] nums) {
 public static int findNumberOfLIS(int[] nums) {
    int n=nums.length;
    int dp[]=new int[n];
     int count[]=new int[n];
      Arrays.fill(dp,1);
      Arrays.fill(count, 1);
    int max=1;
      for( int i=0;i<n;i++){
        for( int pre=0;pre<i;pre++){
            if(nums[i]>nums[pre]&&dp[pre]+1>dp[i]){
                dp[i]=dp[pre]+1;
                count[i]=count[pre];
            }
           else   if(nums[i]>nums[pre]&&dp[pre]+1==dp[i]){
                
                count[i]+=count[pre];
            }
        }
        max=Math.max(max, dp[i]);
       
      }
      int totalLIS=0;
      for( int i=0;i<n;i++){
        if(max==dp[i]){
            totalLIS+=count[i];
        }
      }
        return totalLIS;
    }
  
    public static void main(String[] args) {
        int nums[] = {10,9,2,5,3,7,101,18};

        System.out.println("Longrst Increasing Sub Sequence ");
        System.out.println(Long_Inc_Str(nums, 0, -1));
        System.out.println(lengthOfLIS(nums));

         System.out.println("Printing of LIS");
        PrintLIS(nums);
        System.out.println("Longest divisble subset");
        System.out.println(largestDivisibleSubset(nums));
      String[] words = {"a","ba","bca","bda","bdca"};
System.out.println("Longgest String chain  {leet code 1048}");

          System.out.println(LongestSringChin(words));
System.out.println("Total No of bitonic solutio");
          int arr[]={1,11,2,10,4,5,2,1};
          System.out.println(MaxBitconicSub(arr));

          System.out.println();
          System.out.println("Totat no of LIS in arr2{leetcoden 673}");
           int arr2[]={1,3,5,4,7};
           System.out.println(findNumberOfLIS(arr2));

    }
    
}
