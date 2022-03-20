import java.util.*;

class Solution5 {
    public int canPartition(int[] nums, int diff) {
        int total = 0;
        for (int num : nums)
            total += num;

        if (diff % 2 != 0 && total % 2 == 0)
            return 0;
        if (diff % 2 == 0 && total % 2 != 0)
            return 0;
        /*
         * (1): if given diff is odd and total sum of array is even
         * (2): if given diff is even and total sum of array is odd
         * In these two conditions, it is not possible to break array in two subsets
         * with given difference.
         */

        int reqSum = (total - diff) / 2;
        return isPossible(nums, 0, reqSum, new HashMap<String, Integer>());

    }

    private int isPossible(int[] nums, int currentIndex, int targetSum, HashMap<String, Integer> memo) {
        if (currentIndex == nums.length && targetSum != 0)
            return 0;

        if (currentIndex == nums.length && targetSum == 0)
            return 1;

        String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(targetSum);

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int consider = 0;
        int currentSum = nums[currentIndex];

        if (currentSum <= targetSum && currentSum >= 0)
            consider = isPossible(nums, currentIndex + 1, targetSum - currentSum, memo);

        int notconsider = isPossible(nums, currentIndex + 1, targetSum, memo);

        memo.put(currentKey, consider + notconsider);

        return memo.get(currentKey);
    }
}

class countNoSubWithGivenDiff {
    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        int[] nums = { 2,4,1,3 };
        int diff = 4;
        System.out.println(sol.canPartition(nums, diff));
    }
}