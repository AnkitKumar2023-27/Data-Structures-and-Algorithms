package backtrackingProblem;
import java.util.ArrayList;


public class MobileKeyboard {


    // static String digits[] = {
    //     " ", "ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX", "YZ"
    // };
    
//     public static String digitToStr(int digits) {
//         // Base case
//         if (digits == 0) {
//             return "";
//         }
    
//         // Recursive call to process the next digit
//         String result = digitToStr(digits / 10);
    
//         // Process the current digit
//         int index = digits % 10;
    
//         // Concatenate result
//         return result + digit[index];
//     }
    
   
    
    
//     public static void subset( String str,String ans,int i,int length){
//         if(i==str.length()){
//             if (ans.length() == length) {
//                 System.out.println(ans);
//             }
//            return;
//    }
   
//    //when we add that alphabet
//          subset(str, ans+str.charAt(i), i+1,length);
   
//        //   when we  dont want to add that index/
//        subset(str, ans, i+1,length);
        
//    }




    // Mapping of digits to corresponding letters
    static String[] digitMapping = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static void solve(int length, int idx, ArrayList<Character> list, String digits) {
        if (idx == length) {
            // Print the current combination
            System.out.println(list);
            return;
        }

        char ch = digits.charAt(idx); // Get the character at position idx
        String letters = digitMapping[ch - '0']; // Get the corresponding letters from the mapping

        for (int i = 0; i < letters.length(); i++) {
            // Append the letter and recurse
            list.add(letters.charAt(i));
            solve(length, idx + 1, list, digits);
            // Backtrack by removing the last added character
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int number = 23;
        String digits = String.valueOf(number); // Convert the number to a string
        int length = digits.length();

        // Call the solve function
        solve(length, 0, new ArrayList<>(), digits);
    }
}


