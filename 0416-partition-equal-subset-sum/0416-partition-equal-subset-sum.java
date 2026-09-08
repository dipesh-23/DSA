class Solution {
    public boolean f(int i, int target, int[] nums,int[][] dp){

        if(target == 0){
            return true;
        }
        if(i == nums.length){
            return (target == 0)? true: false;
        }

        if(target < 0){
            return false;
        }

        if(dp[i][target] != -1){
            return dp[i][target] == 1;
        }

        boolean take = f(i+1, target-nums[i],nums,dp);
        boolean nottake = f(i+1,target,nums,dp);

        if((take || nottake) == true){
            dp[i][target] = 1;
        }else{
            dp[i][target] = 0;
        }

        return (take || nottake);
    }
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        if(sum%2 == 1){
            return false;
        }

        int target = sum/2;
        boolean[][] dp = new boolean[n][target+1];
        
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j< target+1; j++){
                boolean nottake = dp[i-1][j];
                boolean take = false;
                if(j > nums[i]){

                     take = dp[i-1][j-nums[i]];
                }

                dp[i][j] = take || nottake;
            }
        }

        return dp[n-1][target];

        
    }
}