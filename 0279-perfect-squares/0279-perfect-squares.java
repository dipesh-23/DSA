import java.util.Arrays;

class Solution {
    public int f(int index, int target, int[][] dp) {
        if (target == 0) return 0;
        
        // Stop if the square exceeds current target
        if (index * index > target) return (int) 1e9;

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        // Take: only recurse if index*index fits in target
        int take = (int) 1e9;
        if (target >= index * index) {
            take = 1 + f(index, target - index * index, dp);
        }
        
        // Notake: skip to the next square number
        int notake = f(index + 1, target, dp);

        return dp[index][target] = Math.min(take, notake);
    }

    public int numSquares(int n) {
        int maxIndex = (int) Math.sqrt(n) + 1;
        int[][] dp = new int[maxIndex + 1][n + 1];

        for (int i = 0; i <= maxIndex; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(1, n, dp);
    }
}