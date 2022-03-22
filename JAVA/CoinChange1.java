// class Solution {
//     public int coinChange(int[] coins, int amount) {

//         HashMap<String,Integer> map = new HashMap<String,Integer>();
//         int ans = minWays(0,coins,amount,map);

//         if(ans == 10001)
//             return -1;

//         return ans;
//     }
//     private int minWays(int currentCoin,int[] coins,int amount,HashMap<String,Integer> map){
//         if(amount == 0)
//             return 0;

//         if(currentCoin == coins.length)
//             return 10001; 

//         int consider = 10001;

//         String currentKey = Integer.toString(currentCoin) +"-"+Integer.toString(amount);

//         if(map.containsKey(currentKey))
//             return map.get(currentKey);

//         if(coins[currentCoin] <= amount)
//             consider = 1 + minWays(currentCoin,coins,amount - coins[currentCoin],map);

//         int notConsider = minWays(currentCoin+1,coins,amount,map);

//         map.put(currentKey,Math.min(consider,notConsider));

//         return map.get(currentKey);
//     }
// }

/*class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans= fewest(coins, 0, amount, new HashMap<String, Integer>());
        if(ans==100000)
            return -1;
        return ans;
    }
    
    public int fewest(int[] coins, int currentIndex, int amt, HashMap<String, Integer> memo){
        
        if(amt==0)
            return 0;
        
        if(currentIndex == coins.length)
            return 100000;
        
        String currentKey = currentIndex + "-" + amt;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int consider=100000;
        if(amt>= coins[currentIndex])
            consider = 1 + fewest(coins, currentIndex, amt-coins[currentIndex], memo);
        
        int notconsider = fewest(coins, currentIndex+1, amt, memo);
        
        memo.put(currentKey, Math.min(consider,notconsider));
        return memo.get(currentKey);
    }
}*/

class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++)
            for (int j = 0; j < amount + 1; j++)
                dp[i][j] = -2;

        int ans = minWays(coins, 0, amount, dp);

        if (ans == 10001)
            return -1;

        return ans;
    }

    private int minWays(int[] coins, int currentIndex, int amount, int[][] dp) {
        if (coins.length == currentIndex)
            return 10001;

        if (amount == 0)
            return 0;

        int currentAmount = coins[currentIndex];

        //String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(amount);

        if (dp[currentIndex][amount] != -2)
            return dp[currentIndex][amount];

        int consider = 10001;

        if (currentAmount <= amount)
            consider = 1 + minWays(coins, currentIndex, amount - currentAmount, dp);
        int notConsider = minWays(coins, currentIndex + 1, amount, dp);

        dp[currentIndex][amount] = Math.min(consider, notConsider);
        return dp[currentIndex][amount];

    }
}
