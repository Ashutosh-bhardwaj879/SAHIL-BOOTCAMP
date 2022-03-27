import java.util.*;

//https://leetcode.com/problems/unique-binary-search-trees/
class Solution96 {
    public int numTrees(int n) {
        return nthCatalan(n, new HashMap<Integer, Integer>());
    }

    private int nthCatalan(int n, HashMap<Integer, Integer> memo) {

        if (n == 0 || n == 1)
            return 1;

        int ways = 0;

        int key = n;

        if (memo.containsKey(key))
            return memo.get(key);

        for (int i = 0; i < n; i++) {
            int a = nthCatalan(i, memo);
            int b = nthCatalan(n - i - 1, memo);
            int c = a * b;
            ways += c;
        }

        memo.put(key, ways);

        return ways;
    }
}