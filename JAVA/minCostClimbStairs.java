package JAVA;

import java.util.*;

public class minCostClimbStairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = scn.nextInt();
        }
        System.out.println(minCostClimb(cost));
        scn.close();
    }

    public static int minCostClimb(int[] cost) {
        // int n = cost.length;
        int startFromZero = minCostClimbingStairs(0, cost, new HashMap<Integer, Integer>());
        int startFromOne = minCostClimbingStairs(1, cost, new HashMap<Integer, Integer>());
        return Math.min(startFromZero, startFromOne);
    }

    public static int minCostClimbingStairs(int currentStair, int[] cost, HashMap<Integer, Integer> memo) {
        if (currentStair == cost.length)
            return 0;
        if (currentStair > cost.length)
            return 1001;
        // return Integer.MAX_VALUE;

        int currentKey = currentStair;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int currentCost = cost[currentStair];

        int oneJump = currentCost + minCostClimbingStairs(currentStair + 1, cost, memo);
        int twoJump = currentCost + minCostClimbingStairs(currentStair + 2, cost, memo);

        memo.put(currentKey, Math.min(oneJump, twoJump));
        //TC ---> O(N) SC --> O(N)
        return Math.min(oneJump, twoJump);
    }
    /*
     * public static int minCostClimbingStairs(int currentStair, int[] cost) {
     * if (currentStair == cost.length)
     * return 0;
     * if (currentStair > cost.length)
     * return 1001;
     * // return Integer.MAX_VALUE;
     * 
     * 
     * int currentCost = cost[currentStair];
     * 
     * int oneJump = currentCost + minCostClimbingStairs(currentStair + 1, cost);
     * int twoJump = currentCost + minCostClimbingStairs(currentStair + 2, cost);
     * 
     * return Math.min(oneJump, twoJump);
     * //TC --> O(2^n)
     * //SC --> O(n)
     * }
     */
}
