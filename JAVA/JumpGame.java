import java.util.*;

//https://leetcode.com/problems/jump-game/
class Solution55 {
    public boolean canJump(int[] nums) {
        return isPossible(nums, 0, new HashMap<Integer, Boolean>());
    }

    private boolean isPossible(int[] nums, int currentIndex, HashMap<Integer, Boolean> memo) {
        if (currentIndex >= nums.length - 1)
            return true;
        // TC for recursive call with o(exp)
        // SC for recursive call with o(n)
        int currentJump = nums[currentIndex];

        int key = currentIndex;

        if (memo.containsKey(key))
            return memo.get(key);

        boolean ans = false;

        for (int i = 1; i <= currentJump; i++) {
            boolean tempAns = isPossible(nums, currentIndex + i, memo);
            ans = ans || tempAns;
        }
        // whenever we have for loop in recursive call
        // max for loop will be max value of currentJump
        // that is like max of nums[i]
        // TC --> O(N*MAX(NUMS[I]))
        // SC --> O(N)

        memo.put(key, ans);

        return ans;
    }
}