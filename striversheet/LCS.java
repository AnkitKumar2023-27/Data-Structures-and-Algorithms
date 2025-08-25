public class LCS {
public static void printLCS(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();

    // Step 1: Build dp table
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    // Step 2: Backtrack to find LCS string
    StringBuilder lcs = new StringBuilder();
    int i = m, j = n;
    while (i > 0 && j > 0) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            lcs.append(s1.charAt(i - 1)); // match → add char
            i--;
            j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--; // move up
        } else {
            j--; // move left
        }
    }

    // Reverse because we built it backwards
    System.out.println(lcs.reverse().toString());
}



    public static void main(String[] args) {
        String s1="abcdt";
         String s2="abdtfg";
         printLCS(s1, s2);
        
    }
    
}
