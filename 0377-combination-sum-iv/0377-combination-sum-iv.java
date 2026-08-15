class Solution {
    
    public int f(int target, int[] nums, int[] dp) {
        
        if (target == 0) {
            return 1;
        }
        
        if (target < 0) {
            return 0;
        }
        
        if (dp[target] != -1) {
            return dp[target];
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans += f(target - nums[i], nums, dp);
        }

        return dp[target] = ans;
    }

    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return f(target, nums, dp);
    }
}