class Solution {
    public int f(int index, int[] pref, int turn, int m,int[][][] dp){
        int n = pref.length;

        if(index >= n) {
            return 0;
        }

        if(dp[index][turn][m] != -1)
            return dp[index][turn][m];

        if(turn == 0){
            int max = -100;
            for(int i=index; i<Math.min(n,index+2*m); i++){
                int x = i-index+1;
                max = Math.max(max,(index ==0? pref[i] : pref[i]-pref[index-1])+f(i+1,pref,1,Math.max(m,x),dp));
            }
            return dp[index][turn][m] = max;
        }else{
            int min = Integer.MAX_VALUE;
            for(int i=index; i<Math.min(n,index+2*m); i++){
                int x = i-index+1;
                min = Math.min(min,f(i+1,pref,0,Math.max(m,x),dp));
            }
            return dp[index][turn][m] = min;
        }
    }
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[] prefix = new int[n];

        prefix[0] = piles[0];

        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1]+piles[i];
        }

        int[][][] dp = new int[n][2][n+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i][0],-1);
            Arrays.fill(dp[i][1],-1);
        }

        return f(0,prefix,0,1,dp);
    }
}