public class TwoFiveSixZero {
// 2560
//     There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
// The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
// You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.
// You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.
// Return the minimum capability of the robber out of all the possible ways to steal at least k houses.

    public static int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Binary search range
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canRob(nums, k, mid)) {
                high = mid; // try smaller capability
            } else {
                low = mid + 1; // need larger capability
            }
        }
        return low;
    }

    private static boolean canRob(int[] nums, int k, int cap) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= cap) {
                count++;
                i += 2; // skip adjacent
            } else {
                i++;
            }
        }
        return count >= k;
    }        
  public static void main(String[] args) {


    
  }
}
