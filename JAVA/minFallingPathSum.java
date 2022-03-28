import java.util.*;

class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        // TC - 0(N*N*m) -> n for loop and hashmap n*m
        // SC - O(N*M) -> values stored in hasmap n*m
        int m = matrix.length;
        int n = matrix[0].length;
        HashMap<String, Integer> memo = new HashMap<>();
        int ans = 10000000;
        for (int currentColumn = 0; currentColumn < n; currentColumn++) {
            int tempAns = minPathSum(matrix, 0, currentColumn, m, n, memo);
            ans = Math.min(ans, tempAns);
        }

        return ans;
    }

    private int minPathSum(int[][] matrix, int currentRow, int currentColumn, int m, int n,
            HashMap<String, Integer> memo) {

        if (currentColumn < 0 || currentColumn >= n)
            return 100001;

        if (currentRow == m - 1)
            return matrix[currentRow][currentColumn];

        String key = currentRow + "-" + currentColumn;

        if (memo.containsKey(key))
            return memo.get(key);

        int leftDiagonal = matrix[currentRow][currentColumn]
                + minPathSum(matrix, currentRow + 1, currentColumn - 1, m, n, memo);

        int down = matrix[currentRow][currentColumn] + minPathSum(matrix, currentRow + 1, currentColumn, m, n, memo);

        int rightDiagonal = matrix[currentRow][currentColumn]
                + minPathSum(matrix, currentRow + 1, currentColumn + 1, m, n, memo);

        memo.put(key, Math.min(down, Math.min(leftDiagonal, rightDiagonal)));

        return Math.min(down, Math.min(leftDiagonal, rightDiagonal));
    }

}