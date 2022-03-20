import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums)
            total += num;
        if (total % 2 != 0)
            return false;
        return isPossible(nums, 0, total / 2, new HashMap<String, Boolean>());

    }

    private boolean isPossible(int[] nums, int currentIndex, int targetSum, HashMap<String, Boolean> memo) {
        if (targetSum == 0)
            return true;

        if (currentIndex >= nums.length)
            return false;

        String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(targetSum);

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        boolean consider = false;
        int currentSum = nums[currentIndex];

        if (currentSum <= targetSum)
            consider = isPossible(nums, currentIndex + 1, targetSum - currentSum, memo);

        if (consider == true) {
            memo.put(currentKey, true);
            return true;
        }
        /*
         * if (currentSum <= targetSum){
         * consider = isPossible(nums, currentIndex + 1, targetSum - currentSum, memo);
         * 
         * if (consider == true) {
         * memo.put(currentKey, true);
         * return true;
         * }
         * }
         */
        boolean notconsider = isPossible(nums, currentIndex + 1, targetSum, memo);

        memo.put(currentKey, consider || notconsider);

        return memo.get(currentKey);
    }
}