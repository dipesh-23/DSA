class Solution {
    int mod = 1000000000+7;
    public int f(int i, int j,int curxor, int[][] grid,int k,int[][][] dp){

        if(i==0 && j==0){
            if((curxor^grid[i][j]) ==k){
                return 1;
            }else{
                return 0;
            }
        }

        if(i<0 || j<0) return 0;
        if(dp[i][j][curxor] != -1){
            return dp[i][j][curxor];
        }

        int up = f(i-1,j,curxor^grid[i][j],grid,k,dp);
        int down= f(i,j-1,curxor^grid[i][j],grid,k,dp);

        return dp[i][j][curxor] = (up+down)%mod;
    }
    public int countPathsWithXorValue(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][16];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j] ,-1);
            }
        }

        return f(m-1,n-1,0,grid,k,dp);

    }
}