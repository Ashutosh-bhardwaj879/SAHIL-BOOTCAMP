import java.util.*;
//https://leetcode.com/problems/edit-distance/submissions/
class Solution72 {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        return minOps(s1, s2, 0, 0, m, n, new HashMap<String, Integer>());
    }

    private int minOps(String s1, String s2, int i, int j, int m, int n, HashMap<String, Integer> memo) {
        // if my ith index is at the index >= length so it menas its exhausted
        // if the second string is remaining we only have one choice to delte all values
        // from seocnd string
        if (i >= m)
            return n - j;
        // if by any chance my jth pointer is at >= length is s2 that means s2 is
        // exhausted
        // and by any chance s1 is remaining then my only chance making s1=s2 is by
        // deleting remaining valus of remaining string s2
        if (j >= n)
            return m - i;

        int ans = 0;

        String key = i + "-" + j;

        if (memo.containsKey(key))
            return memo.get(key);

        // if both char are same at both string then no operaiton need just move to next
        // indexes of two string
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = minOps(s1, s2, i + 1, j + 1, m, n, memo);

        }
        // now if chaars are not equal at indexes we would do our operations

        else {
            // if we insert elemnt in s1 then i (pointer in s1 remains same) nut the jth
            // pointer moves
            // one more becuase the jth index becomes equal to prev index where value
            // isinserted in s1
            int insertion = 1 + minOps(s1, s2, i, j + 1, m, n, memo);
            // if we delete elem in s1 then i index inc by 1 but j remoains same
            int deletion = 1 + minOps(s1, s2, i + 1, j, m, n, memo);
            // if replace then both indexes will be same so boht i,j moves
            int replacing = 1 + minOps(s1, s2, i + 1, j + 1, m, n, memo);
            ans = Math.min(insertion, Math.min(deletion, replacing));
        }

        memo.put(key, ans);

        return ans;
    }
}