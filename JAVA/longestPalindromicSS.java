import java.util.*;

class SolutionLPS {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }
        return longestSubsequence(s, new StringBuilder(s).reverse().toString(), 0, 0, s.length(), s.length(),
                new HashMap<>(), dp);
    }

    private int longestSubsequence(String s1, String s2, int start1, int start2, int end1, int end2,
            HashMap<String, Integer> memo, int[][] dp) {
        if (start1 >= end1 || start2 >= end2)
            return 0;

        int ans = 0;

        if (dp[start1][start2] != -1)
            return dp[start1][start2];
        /*
         * String currentkey = start1+"-"+start2;
         * if(memo.containsKey(currentkey))
         * return memo.get(currentkey);
         */
        if (s1.charAt(start1) == s2.charAt(start2)) {
            ans = 1 + longestSubsequence(s1, s2, start1 + 1, start2 + 1, end1, end2, memo, dp);
        }

        else {
            int a = longestSubsequence(s1, s2, start1, start2 + 1, end1, end2, memo, dp);
            int b = longestSubsequence(s1, s2, start1 + 1, start2, end1, end2, memo, dp);
            ans = Math.max(a, b);
        }
        /* memo.put(currentkey,ans); */
        dp[start1][start2] = ans;
        return ans;

        // REC
        // TC -- O(2^MIN(M,N))
        // SC -- O(MIN(M,N))

        // DP
        // TC -- O(M*N)
        // SC -- O(M*N)
    }
}
