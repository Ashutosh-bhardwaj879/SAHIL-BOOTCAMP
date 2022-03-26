import java.util.*;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class Solution122 {
    // as many transaction as you want you can do so no need of this
    // transactionCount variable
    public int maxProfit(int[] prices) {
        int canBuy = 1;
        // int transactionCount = k;//at most k transaction allowed
        int startingDay = 0;// we can start buying selling from day 0
        HashMap<String, Integer> memo = new HashMap<>();
        return totalProfit(prices, startingDay, canBuy, memo);
    }

    // at each index we have 3 choice
    // 1-remain idle
    // 2-buy the item
    // 3-sell if bought item earlier
    private int totalProfit(int[] prices, int currentDay, int canBuy, HashMap<String, Integer> memo) {

        if (currentDay >= prices.length)
            return 0;

        int ans = 0;

        String key = currentDay + "-" + canBuy;

        if (memo.containsKey(key))
            return memo.get(key);

        // if we are buying some item then we have to give some money from our pocket
        // thts why -prices[CD] is used
        if (canBuy == 1) {
            int idle = totalProfit(prices, currentDay + 1, canBuy, memo);
            canBuy = 0;
            int buy = -prices[currentDay] + totalProfit(prices, currentDay + 1, canBuy, memo);
            ans = Math.max(idle, buy);
        } else {
            // if we are selling some item then we will get some money in pocket thats why
            // +prices[currentDay]
            int idle = totalProfit(prices, currentDay + 1, canBuy, memo);
            canBuy = 1;
            // uf we are calling a function at sell thats means we will complete the
            // trnsaction
            int sell = prices[currentDay] + totalProfit(prices, currentDay + 1, canBuy, memo);
            ans = Math.max(idle, sell);
        }
        // transaction == B and S

        memo.put(key, ans);

        return ans;
    }
}