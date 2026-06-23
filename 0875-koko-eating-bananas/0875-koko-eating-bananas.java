class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int max = 0;

        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int low = 1;
        int high = max;
        int ans = 0;

        while(low <= high){
            int mid = low + (high-low)/2;

            long m = solve(nums,mid);

            if(m <= h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    static long solve(int[] nums, int k){
        
        long hr= 0;

        for(int i=0; i<nums.length; i++){
            hr += (int)Math.ceil((double)nums[i]/k);
        }

        return hr;
    }
}