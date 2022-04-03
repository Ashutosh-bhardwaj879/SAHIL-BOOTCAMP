
//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
import java.util.*;

class Solution1155 {
    public int numRollsToTarget(int d, int f, int target) {
        return totalWays(d, f, target, new HashMap<String, Integer>());
    }

    private int totalWays(int n, int f, int targetSum, HashMap<String, Integer> memo) {
        // we used all dices and got targetSum
        if (n == 0 && targetSum == 0)
            return 1;

        // we used all dices but still could not get targetSum
        if (n == 0 && targetSum != 0)
            return 0;

        // we have to use all dices to obtain targetSum
        // here we didnt use all dices and got targetSum or lesser than that
        if (n != 0 && targetSum <= 0)
            return 0;

        int MOD = 1000000007;

        int ways = 0;

        String key = n + "-" + targetSum;

        if (memo.containsKey(key))
            return memo.get(key);

        // we called all the branches of the faces of a single dice
        for (int i = 1; i <= f; i++) {
            // reduced dice count and targetSum
            int tempAns = totalWays(n - 1, f, targetSum - i, memo) % MOD;
            ways = ways % MOD;
            ways = (ways + tempAns) % MOD;
        }

        memo.put(key, ways);

        return ways;
    }
}