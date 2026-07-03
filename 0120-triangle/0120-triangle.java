class Solution {

    public static int f(int i, int j,List<List<Integer>> t,int[][] dp){

        if(i == t.size() - 1){
            return t.get(i).get(j);
        }

        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int down = t.get(i).get(j) + f(i+1,j,t,dp);
        int diag = t.get(i).get(j) + f(i+1,j+1,t,dp);

        return dp[i][j] = Math.min(down,diag);

    }
    public int minimumTotal(List<List<Integer>> t) {
        
        // int m = t.size();
        // int n = m;
        // int[][] dp = new int[m][n];

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<=i; j++){

        //         if(i==0 && j==0){
        //             dp[i][j] = t.get(i).get(j);
        //             continue;
        //         }

        //         int up = t.get(i).get(j);
        //         int left = t.get(i).get(j);

        //         if(i<=0) up+= 100000;
        //         else up+= dp[i-1][j];

        //         if(j<=0) left+= 100000;
        //         else left+= dp[i-1][j-1];

        //         dp[i][j] = Math.min(up,left); 
        //     }
        // }
        
        // int ans = Integer.MAX_VALUE;
        // for(int i=0; i<m; i++){
        //     ans = Math.min(ans,dp[m-1][i]);
        // }

        int m = t.size();
        int[][] dp = new int[m][m];

        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return f(0,0,t,dp);
    }
}