class Solution {
    public int solve(int i, int j , int[][] dp,int[][] grid){

        if(i== 0 && j==0){
            return grid[i][j];
        }

        if(i<0 || j <0){
            return Integer.MAX_VALUE/2;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int left =grid[i][j]+solve(i-1,j,dp,grid);
        int up = grid[i][j]+solve(i,j-1,dp,grid);

        return dp[i][j] = Math.min(left,up);

    }
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length; 

        int[][] dp = new int[m][n];


        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int up=grid[i][j];
                int left = grid[i][j];

                if(i<=0){
                    up += Integer.MAX_VALUE/2;
                }else{
                    up += dp[i-1][j];
                }
                    
                if(j<=0) {
                    left += Integer.MAX_VALUE/2;
                }else{
                    left += dp[i][j-1];
                }

                dp[i][j] = Math.min( up,left);
            }
        }

        return dp[m-1][n-1];
    }
}