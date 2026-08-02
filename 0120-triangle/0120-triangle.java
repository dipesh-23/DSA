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

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        return f(0,0,t,dp);
    }
}