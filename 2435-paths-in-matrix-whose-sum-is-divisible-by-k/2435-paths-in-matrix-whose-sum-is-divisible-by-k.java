class Solution {
    int mod = 1000000000+7;

    public int f(int i, int j, int[][] grid, int k,int currsum,int[][][] dp){
        if(i==0 && j==0){
            if((currsum+grid[i][j])%k == 0){
                return 1;
            }
            return 0;
        }

        if(i <0 || j<0) return 0;

        if(dp[i][j][currsum] != -1){
            return dp[i][j][currsum];
        }

        int up = f(i-1,j,grid,k, (currsum+grid[i][j])%k,dp);
        int left = f(i,j-1,grid,k,(currsum+grid[i][j])%k,dp);

        return dp[i][j][currsum] =(up+left)%mod;

    }
    public int numberOfPaths(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }

        return f(m-1,n-1,grid,k,0,dp);
    }
}