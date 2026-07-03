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
        //Here we staarted memoizaton from 0,0 why because if we start from last there are n states to  maintain for sum so why cant we start from single state 0,0
        int m = t.size();
        int n = m;
        int[][] dp = new int[m][n];

        //Tabulation is exactly opp of what u have done in memoization.
        //base case is for row n-1

        int[] prev = new int[n];
        for(int i=0; i<n; i++){
            prev[i] = t.get(n-1).get(i);
        }

        for(int i=n-2; i>=0; i--){
            int[] temp = new int[n];
            for(int j=0; j<=i; j++){

                temp[j] = t.get(i).get(j)+Math.min(prev[j],prev[j+1]);
            }

            prev = temp;
        }

        return prev[0];
        //space optimize using the prev and temp arr;

        // for(int i=0; i<m; i++){
        //     Arrays.fill(dp[i],Integer.MAX_VALUE);
        // }
        // return f(0,0,t,dp);
    }
}