import java.util.*;
//https://leetcode.com/problems/jump-game-ii/
class Solution45 {
    public int jump(int[] nums) {
        return isPossible(nums, 0, new HashMap<Integer, Integer>());
    }

    private int isPossible(int[] nums, int currentIndex, HashMap<Integer, Integer> memo) {
        if (currentIndex >= nums.length - 1)
            return 0;

        if (nums[currentIndex] == 0)
            return 10001;

        int key = currentIndex;

        int currentJump = nums[currentIndex];

        int ans = 10001;

        if (memo.containsKey(key))
            return memo.get(key);

        for (int x = 1; x <= currentJump; x++) {
            int tempAns = 1 + isPossible(nums, currentIndex + x, memo);
            ans = Math.min(ans, tempAns);
        }

        memo.put(key, ans);
        return ans;

    }
}