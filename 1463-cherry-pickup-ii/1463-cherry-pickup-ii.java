class Solution {
    
    public int solve(int i, int j1, int j2 , int[][][] dp,int grid[][]){
        
        int m = grid.length;
        int n = grid[0].length;
        if(j1 <0 || j1>=n || j2 <0 || j2 >=n){
            return -100000;
        }
        
        if(i == m-1){
            
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        
        int maxi = 0;
        
        for(int a=-1; a<=1; a++){
            for(int b=-1; b<=1; b++){
                
                if(j1== j2){
                    maxi = Math.max(maxi, grid[i][j1]+ solve(i+1,j1+a,j2+b,dp,grid));
                }else{
                    maxi = Math.max(maxi,grid[i][j1]+grid[i][j2]+ solve(i+1,j1+a,j2+b,dp,grid));
                }
            }
        }
        
        return dp[i][j1][j2] = maxi;
        
    }
    public int cherryPickup(int grid[][]) {
        
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        return solve(0,0,n-1,dp,grid);
        
    }
}