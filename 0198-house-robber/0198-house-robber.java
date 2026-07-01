class Solution {
    //Memoization solution
    // public static int f(int index, int[] nums,int[] dp){
    //     if(index == 0) return nums[index];
    //     if(index < 0) return 0;
    //     if(dp[index]  != -1){
    //         return dp[index];
    //     }

    //     int notpick = f(index-1,nums,dp);
    //     int pick = nums[index] + f(index-2,nums,dp);

    //     return dp[index] = Math.max(pick,notpick);
    // }

    public int rob(int[] nums) {
        
        int[] dp = new int[nums.length];
        int n = nums.length;

        dp[0] = nums[0];

        for(int i=1; i<n; i++){

            int take = nums[i];
            if(i > 1) take += dp[i-2];
            int notake = dp[i-1];

            dp[i] = Math.max(take,notake);
        }

        return dp[n-1];
        // r eturn  f(nums.length-1, nums,dp);
    }
}