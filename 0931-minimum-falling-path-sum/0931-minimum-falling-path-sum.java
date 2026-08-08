class Solution {
    public int f(int i, int j, int[][] mat,int[][] dp ){

        if(j <0 || j>= mat[0].length){
            return Integer.MAX_VALUE/5;
        }

        if(i==mat.length-1){
            return mat[i][j];
        }

        if(dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }

        int left = mat[i][j] +f(i+1,j-1,mat,dp);
        int down = mat[i][j]+f(i+1,j,mat,dp);
        int up = mat[i][j]+f(i+1,j+1,mat,dp);

        return dp[i][j] = Math.min(Math.min(up,down),left); 

    }

    public int minFallingPathSum(int[][] mat) {
        
        int min = Integer.MAX_VALUE;
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }

        for(int i=0; i<mat[0].length; i++){
           min= Math.min(min,f(0,i,mat,dp));
        }

        return min;
    }
}