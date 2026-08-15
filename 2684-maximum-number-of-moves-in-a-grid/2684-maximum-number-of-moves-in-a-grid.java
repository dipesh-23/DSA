class Solution {
    public int f(int i, int j, int[][] grid, int m, int n,int[][] dp) {

        if(j == n - 1) {
            return 0;
        }

        int ans = 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i - 1 >= 0 &&
        grid[i - 1][j + 1] > grid[i][j]) {
            ans = Math.max(ans, 1 + f(i - 1, j + 1, grid, m, n,dp));
        }

        if(grid[i][j + 1] > grid[i][j]) {
            ans = Math.max(ans, 1 + f(i, j + 1, grid, m, n,dp));
        }

        if(i + 1 < m &&
        grid[i + 1][j + 1] > grid[i][j]) {
            ans = Math.max(ans, 1 + f(i + 1, j + 1, grid, m, n,dp));
        }

        return dp[i][j] = ans;
    }
    public int maxMoves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }

        int max =Integer.MIN_VALUE;

        for(int i=0; i<m; i++){
            max = Math.max(max, f(i,0,grid,m,n,dp));
        }

        return max;
    }
}