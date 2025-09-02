public class SevenFourZero {

//     You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
// Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
// Return the maximum number of points you can earn by applying the above operation some number of times.

    public static int deleteAndEarn(int[] nums) {
       int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

       
        int[] result = new int[max + 1];

     
        for (int num : nums) {
            result[num] += num;
        }
     int dp[]=new int[max+1];

     dp[0]=result[0];
     dp[1]=Math.max(result[0],result[1]);
     for( int i=2;i<max+1;i++){
        dp[i]=Math.max(dp[i-1],dp[i-2]+result[i]);
        
     }
     return dp[max];
    }

  
 
  public static void main(String[] args) {

        int nums[]={3,4,2};
        System.out.println(deleteAndEarn(nums));
        
    }


    
}
