class Solution {
    public int f(int index, int[] coins, int target,int[][] dp){

        if(target < 0 || index == coins.length) return (int)1e9;

        if(target == 0){
            return 0;
        }

        if(dp[index][target] != -1){
            return dp[index][target];
        }

        int take = 1+f(index,coins,target-coins[index],dp);
        int notake = f(index+1,coins,target,dp);

        return dp[index][target]= Math.min(take,notake);
    }
    public int coinChange(int[] coins, int amount) {

        int n = coins.length; 
        int[][] dp = new int[n][amount+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = f(0,coins,amount,dp);
        if(ans == (int)1e9){
            return -1;
        }

        return ans;
    }
}