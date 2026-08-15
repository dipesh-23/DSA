class Solution {
    public int f(int i, int k, int[] nums,int[] dp){

        if( i<0 ){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int max = nums[i];
        int ans = Integer.MIN_VALUE;
        for(int j=i; j>=Math.max(0,i-k+1); j--){
            max= Math.max(max,nums[j]);
            ans = Math.max(ans,(i-j+1)*max+ f(j-1,k,nums,dp));
        }

        return dp[i] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp,-1);
        return f(arr.length-1,k,arr,dp);
    }
}