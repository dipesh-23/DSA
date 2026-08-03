class Solution {
    public static long f(int i, int[] a, int[] b,int turn,long[][] dp){

        if(i == a.length-1){
            if(turn == 0){
                return a[i];
            }

            return b[i];
        }

        if(i >= a.length){
            return 0;
        }

        if(dp[i][turn]  != -1){
            return dp[i][turn];
        }

        if(turn == 0){

            long left = a[i]+f(i+1,a,b,turn,dp);
            long right = a[i]+f(i+2,a,b,turn^1,dp);

            return dp[i][turn] = Math.max(left,right);
        }else{
            long left = b[i]+f(i+1,a,b,turn,dp);
            long right = b[i]+f(i+2,a,b,turn^1,dp);

            return dp[i][turn] = Math.max(left,right);
        }

    }
    public long maxEnergyBoost(int[] a, int[] b) {
        long ans = 0;

        int n = a.length;
        long[][] dp = new long[n][2];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        
        ans= Math.max(f(0,a,b,0,dp),f(0,a,b,1,dp));

        return ans;
    }
}