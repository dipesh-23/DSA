class Solution {

    public int f(int index,int target, int[] nums,int[][] dp){

        if(target ==0){
            return 1;
        }

        if(target<0 || index == nums.length){
            return 0;
        }

        if(dp[index][target] != -1){
            return dp[index][target];
        }
        int ans =0;
        for(int i=index; i<nums.length; i++){
            ans += f(i,target-nums[i],nums,dp);
        }

        return  dp[index][target] = ans;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }

        return f(0,amount,coins,dp);
    }
}