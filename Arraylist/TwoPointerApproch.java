import java.util.ArrayList;

public class TwoPointerApproch {
    static ArrayList<Integer>list=new ArrayList<>();
    static ArrayList<Integer>list2=new ArrayList<>();
 //sum in sorted Array
    

        public static boolean SumInSortedList(ArrayList<Integer> list, int target) {
            int left = 0; // Start pointer
            int right = list.size() - 1; // End pointer
    
            while (left < right) {
                int sum = list.get(left) + list.get(right);
    
                if (sum == target) {
                    return true; // Pair found
                }
    
                if (sum < target) {
                    left++; // Move the left pointer forward
                } else {
                    right--; // Move the right pointer backward
                }
            }
    
            return false; // No pair found
        }

// $$$$$$$$$$$$$$$$$$$$$$$$$$$$//  SUM IN SORTED AND ROTEADED ARRAY*******************************
        public static boolean SumInRotatedSortedList(ArrayList<Integer> list, int target) {
            int bp = -1; // Initialize breakpoint index
            for (int i = 0; i < list.size() - 1; i++) { 
                if (list.get(i) > list.get(i + 1)) { 
                    bp = i; 
                    break; 
                }
            }
            
            int left = bp+1; // Start pointer
            int right = bp; // End pointer
                int n=list.size();
            while (left != right) {
                int sum = list.get(left) + list.get(right);
    
                if (sum == target) {
                    return true; // Pair found
                }
    
                if (sum < target) {
                    left=(left+1)%n; // Move the left pointer forward
                } else {
                    right=(n+right-1)%n; // Move the right pointer backward
                }
            }
    
            return false; // No pair found
        }

//sum in rotated sorted Array

    
        public static void main(String[] args) {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            System.out.println("List: " + list);
    
            // Test cases
            System.out.println("Is there a pair with sum 8? " + SumInSortedList(list, 8)); // Expected: true
            System.out.println("Is there a pair with sum 10? " + SumInSortedList(list, 10)); // Expected: false

            list2.add(5);
            list2.add(6);
            list2.add(2);
            list2.add(3);
            list2.add(4);

            System.out.println(list2);
            System.out.println("Is there a pair with sum 8? " + SumInRotatedSortedList(list2, 8)); // Expected: true
            System.out.println("Is there a pair with sum 10? " + SumInRotatedSortedList(list2, 10)); // Expected: false

        }
    }
    

