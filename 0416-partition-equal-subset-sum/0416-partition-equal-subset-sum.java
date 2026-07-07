class Solution {

    public boolean solve(int index, int target,int[] nums, int[][] dp){
        if(index == 0) return (nums[0] == target);

        if(target == 0){
            return true;
        }

        if(dp[index][target] != -1){
            return (dp[index][target]==0)? true : false;
        }

        boolean take = (nums[index] > target) ? false :solve(index-1, target-nums[index],nums,dp);
        boolean nottake = solve(index-1, target, nums,dp);

        dp[index][target] = (take | nottake)? 0 : 1;

        return take | nottake;
    }
    public boolean canPartition(int[] nums) {
        
        int n = nums.length;
        long sum = 0;
        for(int i=0; i<n; i++){
            sum+= nums[i];
        }

        if(sum%2 == 1){
            return false;
        }

        int target = (int)sum/2;
        int[][] dp = new int[n][target+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }    

        return solve(n-1,target,nums,dp);
    }
}