/*
    Time Complexity: O(N)
    Space Complexity: O(N)

    where 'N' is the number of stairs in the staircase.
*/

class FrogJump {

    private static int rec(int i, int heights[], int dp[]) {

        if (i == heights.length - 1) {
            // Reached the last stair.
            return 0;
        }

        if (dp[i] != -1) {
            // Pre-computed value found.
            return dp[i];
        }

        // Two available choices.
        int oneJump = Integer.MAX_VALUE;
        int twoJump = Integer.MAX_VALUE;

        if (i + 1 < heights.length) {
            oneJump = Math.abs(heights[i] - heights[i + 1]) + rec(i + 1, heights, dp);
        }

        if (i + 2 < heights.length) {
            twoJump = Math.abs(heights[i] - heights[i + 2]) + rec(i + 2, heights, dp);
        }

        int ans = Math.min(oneJump, twoJump);
        dp[i] = ans;
        return ans;
    }

    public static int frogJump(int n, int heights[]) {
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        int ans = rec(0, heights, dp);
        return ans;
    }
}