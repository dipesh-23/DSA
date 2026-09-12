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

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        // Fill row 0 (using only coins[0])
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = (int) 1e9;
            }
        }

        for(int i=1; i<n; i++){
            for(int j=0; j< amount+1; j++){

                int take = (int)1e9;
                if(j >= coins[i]){
                    take = 1+dp[i][j-coins[i]];
                }

                int notake = dp[i-1][j];

                dp[i][j] = Math.min(take,notake);
            }
        }

        // int ans = f(0,coins,amount,dp);
        int ans = dp[n-1][amount];
        if(ans == (int)1e9){
            return -1;
        }

        return ans;
    }
}