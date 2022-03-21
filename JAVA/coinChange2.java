import java.util.*;

class Solution11 {
    public int change(int amount, int[] coins) {
        return totalWays(amount, coins, 0, new HashMap<String, Integer>());
    }

    private int totalWays(int amount, int[] coins, int currentCoin, HashMap<String, Integer> memo) {

        if (amount == 0)
            return 1;

        if (currentCoin == coins.length)
            return 0;

        String key = Integer.toString(currentCoin) + "-" + Integer.toString(amount);

        if (memo.containsKey(key))
            return memo.get(key);

        int consider = 0;

        if (coins[currentCoin] <= amount)
            consider = totalWays(amount - coins[currentCoin], coins, currentCoin, memo);

        int notConsider = totalWays(amount, coins, currentCoin + 1, memo);

        memo.put(key, consider + notConsider);

        return consider + notConsider;

    }
}
