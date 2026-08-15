class Solution {
    public int f(int index, int[] cost,int[] dp){
        
        int n = cost.length;
        if(index == n-1){
            return 0;
        }

        if(index>=n){
            return Integer.MAX_VALUE/5;
        }
        if(dp[index+1] != -1){
            return dp[index+1];
        }

        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;
        if(index+1 < n){
            one =cost[index+1] + 1+f(index+1,cost,dp);
        }
        if(index+2 < n){
            two =cost[index+2] + 4+f(index+2,cost,dp);
        }
        if(index+3 < n){
            three =cost[index+3] + 9+f(index+3,cost,dp);
        }
        

        return dp[index+1] = Math.min(one,Math.min(two,three));
    }

    public int climbStairs(int n, int[] costs) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(-1,costs,dp);
    }
}