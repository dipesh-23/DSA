class Solution {
    public int minDays(int[] nums, int m, int k) {
    
        if(1L*m*k > nums.length){
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = 0;

        for(int i=0; i<nums.length; i++){
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;

            int p = solve(nums,k,mid);

            if(p >= m){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    
    }
    static int solve(int[] nums, int k, int d){
        int bloom= 0;
        int boq = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] <= d){
                bloom++;
            }else{
                boq += (bloom)/k;
                bloom = 0;
            }
        }

        boq += (bloom)/k;
        return boq;
    }
}