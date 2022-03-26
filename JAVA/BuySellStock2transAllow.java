//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/
//at most 2 transactions allowed
class Solution123 {
    public int maxProfit(int[] prices) {
        // int canBuy = 1;
        // int transactionCount = 2;//at most k transaction allowed
        // int startingDay = 0;//we can start buying selling from day 0

        int[][][] dp = new int[prices.length + 1][2][3];

        for (int day = 0; day < prices.length + 1; day++) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int transactionCount = 0; transactionCount < 3; transactionCount++) {
                    dp[day][canBuy][transactionCount] = -1;
                }
            }
        }
        return totalProfit(prices, 0, 1, 2, dp);
        // return totalProfit(prices,startingDay,canBuy,transactionCount,dp);
    }

    // at each index we have 3 choice
    // 1-remain idle
    // 2-buy the item
    // 3-sell if bought item earlier
    private int totalProfit(int[] prices, int currentDay, int canBuy, int transactionCount, int[][][] dp) {
        if (currentDay == prices.length)
            return 0;
        if (transactionCount == 0)
            return 0;

        if (dp[currentDay][canBuy][transactionCount] != -1)
            return dp[currentDay][canBuy][transactionCount];

        // if we are buying some item then we have to give some money from our pocket
        // thts why -prices[CD] is used
        if (canBuy == 1) {
            int idle = totalProfit(prices, currentDay + 1, canBuy, transactionCount, dp);

            int buy = -prices[currentDay] + totalProfit(prices, currentDay + 1, 0, transactionCount, dp);

            dp[currentDay][canBuy][transactionCount] = Math.max(idle, buy);

            return dp[currentDay][canBuy][transactionCount];
        } else {

            int idle = totalProfit(prices, currentDay + 1, canBuy, transactionCount, dp);

            int sell = prices[currentDay] + totalProfit(prices, currentDay + 1, 1, transactionCount - 1, dp);

            dp[currentDay][canBuy][transactionCount] = Math.max(idle, sell);

            return dp[currentDay][canBuy][transactionCount];
        }

    }
}