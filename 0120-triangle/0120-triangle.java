class Solution {
    public static int f(int i, int j,List<List<Integer>> t,int[][] dp){

        if(i == t.size()-1){
            return t.get(i).get(j);
        }

        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int left = t.get(i).get(j) + f(i+1,j,t,dp);
        int right = t.get(i).get(j) + f(i+1,j+1,t,dp);

        return dp[i][j] =Math.min(left,right);
    }
    public int minimumTotal(List<List<Integer>> t) {
        
        int n = t.size();
        int m = t.get(n-1).size();

        int[][] dp = new int[n][m];

        for(int i=0; i<m; i++){
            dp[n-1][i] = t.get(n-1).get(i);
        }

        for(int i= n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                
                int right = 0;
                right = t.get(i).get(j)+dp[i+1][j+1];

                int left = t.get(i).get(j)+dp[i+1][j];

                dp[i][j] = Math.min(left,right);
            }
        }

        return dp[0][0];
    }
}