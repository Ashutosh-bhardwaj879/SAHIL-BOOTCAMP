import java.util.*;

class Solution9 {
    static int knapSack(int N, int capacity, int val[], int wt[]) {
        int[][] dp = new int[N + 1][capacity + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return maxProfit(N, capacity, val, wt, 0, new HashMap<String, Integer>(), dp);
    }

    private static int maxProfit(int N, int capacity, int[] val, int[] wt, int currentItem,
            HashMap<String, Integer> memo, int[][] dp) {
        if (capacity == 0)
            return 0;

        if (currentItem == N)
            return 0;

        int consider = 0;

        int currentWeight = wt[currentItem];
        int currentProfit = val[currentItem];

        // String key = Integer.toString(currentItem) + "-" +
        // Integer.toString(capacity);
        // if(memo.containsKey(key))
        // return memo.get(key);

        if (dp[currentItem][capacity] != -1)
            return dp[currentItem][capacity];

        if (currentWeight <= capacity)
            consider = currentProfit + maxProfit(N, capacity - currentWeight, val, wt, currentItem, memo, dp);

        int notConsider = maxProfit(N, capacity, val, wt, currentItem + 1, memo, dp);

        // memo.put(key,Math.max(consider,notConsider));

        dp[currentItem][capacity] = Math.max(consider, notConsider);

        return Math.max(consider, notConsider);
        // return memo.get(key);
    }
}