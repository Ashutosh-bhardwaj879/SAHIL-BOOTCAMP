import java.util.*;
//TC -> O(N*W)
//SC -> O(N*W)
class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Solution3 sol = new Solution3();
        int N = scn.nextInt();
        int W = scn.nextInt();

        int[] val = new int[N];

        for (int i = 0; i < N; i++)
            val[i] = scn.nextInt();

        int[] wt = new int[N];
        for (int i = 0; i < N; i++)
            wt[i] = scn.nextInt();

        int result = sol.knapSack(W,wt,val,N);
        System.out.println(result);
        scn.close();
    }
}

class Solution3 {
    // Function to return max value that can be put in knapsack of capacity W.
    public int knapSack(int W, int wt[], int val[], int n) {
        return maxProfit(0, W, wt, val, n, new HashMap<String, Integer>());
    }

    private  int maxProfit(int currentItem, int capacity, int weight[], int profit[], int n,
            HashMap<String, Integer> memo) {
        if (currentItem == n)
            return 0;

        int currentWeight = weight[currentItem];
        int currentProfit = profit[currentItem];

        int considerd = 0;

        String currentKey = Integer.toString(currentItem) + "-" + Integer.toString(capacity);

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        if (currentWeight <= capacity)
            considerd = currentProfit + maxProfit(currentItem + 1, capacity - currentWeight, weight, profit, n, memo);

        int notConsiderd = maxProfit(currentItem + 1, capacity, weight, profit, n, memo);

        memo.put(currentKey, Math.max(considerd, notConsiderd));

        return Math.max(considerd, notConsiderd);
    }
}