class Solution {

    public static int f(int i,int[] nums,int[] dp){
        
        if(i ==0) return nums[0];
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i];

        int take = nums[i]+f(i-2,nums,dp);
        int nottake = f(i-1,nums,dp);

        return dp[i] = Math.max(take,nottake);
    }

    public static int f2(int i,int[] nums,int[] dp){
        
        if(i ==1) return nums[1];
        if(i<1) return 0;
        if(dp[i] != -1) return dp[i];

        int take = nums[i]+f2(i-2,nums,dp);
        int nottake = f2(i-1,nums,dp);

        return dp[i] =Math.max(take,nottake);
    }

    public int rob(int[] nums) {
        
        int n= nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        if(n==1) return nums[0];
        int a1 = f(n-2,nums,dp);
        Arrays.fill(dp,-1);
        int a2 = f2(n-1,nums,dp);

        return Math.max(a1,a2);
    }
}