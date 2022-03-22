//https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
import java.util.*;

class Solution22 {
    public int cutRod(int price[], int l) {
        return maxProfit(price, l, 0, new HashMap<String, Integer>());
    }

    private int maxProfit(int price[], int l, int currentIndex, HashMap<String, Integer> memo) {
        if (l == 0)
            return 0;

        if (currentIndex == price.length)
            return 0;

        int consider = 0;
        int currentLength = currentIndex + 1;

        String key = currentIndex + "-" + l;

        if (memo.containsKey(key))
            return memo.get(key);

        if (currentLength <= l)
            consider = price[currentIndex] + maxProfit(price, l - currentLength, currentIndex, memo);

        int notConsider = maxProfit(price, l, currentIndex + 1, memo);

        memo.put(key, Math.max(consider, notConsider));

        return Math.max(consider, notConsider);
    }
}