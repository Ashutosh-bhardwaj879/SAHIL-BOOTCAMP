import java.util.*;

class Solution7 {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);

        int maxElement = nums[nums.length - 1];

        int[] freq = new int[maxElement + 1];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        return totalPoints(freq, 0, new HashMap<Integer, Integer>());
    }

    private int totalPoints(int[] freq, int currentIndex, HashMap<Integer, Integer> memo) {
        if (currentIndex >= freq.length)
            return 0;

        int currentKey = currentIndex;

        if (memo.containsKey(currentKey))
            return memo.get(currentKey);

        int delete = currentIndex * freq[currentIndex] + totalPoints(freq, currentIndex + 2, memo);

        int noDelete = totalPoints(freq, currentIndex + 1, memo);

        memo.put(currentKey, Math.max(delete, noDelete));

        return Math.max(delete, noDelete);
    }
}
