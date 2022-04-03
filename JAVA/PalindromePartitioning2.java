import java.util.*;

class Solution132 {
    public int minCut(String s) {
        int end = s.length() - 1;
        int start = 0;
        return minimumCuts(s, start, end, new HashMap<Integer, Integer>());
    }

    // cuts will be made till end - 1
    // we have to make intelligent cuts
    // intelligent cuts means I will cut only if the left half is palindrome
    // and check for palindrome of right half
    private int minimumCuts(String s, int start, int end, HashMap<Integer, Integer> memo) {

        if (isPalindrome(s, start, end)) {
            return 0;
        }

        int ans = 10000001;
        // we will make intelligent cuts till the length of end - 1
        // strt start+1 start+2 .....end -1

        int key = start;

        if (memo.containsKey(key))
            return memo.get(key);

        for (int i = start; i < end; i++) {

            // checking left half for plaindrome{

            if (isPalindrome(s, start, i)) {

                // calling intellignet cuts for right half

                int intelligentCuts = 1 + minimumCuts(s, i + 1, end, memo);

                ans = Math.min(ans, intelligentCuts);
            }
        }

        memo.put(key, ans);
        return ans;
    }

    private boolean isPalindrome(String s, int i, int j) {

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class PalindromePartitioning2 {
    public static void main(String[] args) {
        Solution132 sol132 = new Solution132();
        String s = "abacd";
        sol132.minCut(s);
    }
}
