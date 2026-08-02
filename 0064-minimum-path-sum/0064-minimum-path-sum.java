class Solution {
    public static int f(int i, int j , int[][] grid,int[][] dp){

        if(i==0 && j == 0){
            return grid[i][j];
        }

        if(i<0){
            return Integer.MAX_VALUE/5;
        }

        if(j<0){
            return Integer.MAX_VALUE/5;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int left = grid[i][j]+ f(i,j-1,grid,dp);
        int up = grid[i][j]+ f(i-1,j,grid,dp);

        return dp[i][j] = Math.min(up,left);

    }
    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0){
                    dp[0][0] = grid[0][0];
                    continue;
                }

                dp[i][j]  = grid[i][j];
                int left = 0;
                int up = 0;

                if(j==0){
                    left = Integer.MAX_VALUE/5;
                }else{
                    left = dp[i][j-1];
                }

                if(i==0){
                    up = Integer.MAX_VALUE/5;
                }else{
                    up = dp[i-1][j];
                }

                dp[i][j] += Math.min(up,left);
            }
        }

        return dp[n-1][m-1];
       
    }
}