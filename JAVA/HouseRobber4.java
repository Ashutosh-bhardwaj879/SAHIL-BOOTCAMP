//https://leetcode.com/problems/house-robber/
package JAVA;
import java.util.*;

class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        return maxMoney(0, nums, map);
    }

    private int maxMoney(int currentHouse, int[] nums, HashMap<Integer, Integer> map) {

        if (currentHouse >= nums.length)
            return 0;

        int currentKey = currentHouse;

        if (map.containsKey(currentKey))
            return map.get(currentKey);

        int HouseRobbed = nums[currentKey] + maxMoney(currentHouse + 2, nums, map);
        int NoHouseRobbed = maxMoney(currentHouse + 1, nums, map);

        map.put(currentKey, Math.max(HouseRobbed, NoHouseRobbed));

        return Math.max(HouseRobbed, NoHouseRobbed);
        // TC -- O(N)
        // SC -- O(N)
    }
}

class HouseRobber4 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3,1};
        System.out.println(sol.rob(nums));
    }
}
