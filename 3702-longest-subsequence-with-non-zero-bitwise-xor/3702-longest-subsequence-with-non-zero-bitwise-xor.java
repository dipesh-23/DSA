class Solution {
    public int longestSubsequence(int[] nums) {
        int xor =0;
        int n = nums.length;
        int flag =0;

        for(int i=0; i<n; i++){
            xor = xor^nums[i];

            if(nums[i] != 0){
                flag =1;
            }
        }

        if(xor == 0 && flag == 1){
            return n-1;
        }else if(xor==0 && flag == 0){
            return 0;
        }

        return n;
    }
}