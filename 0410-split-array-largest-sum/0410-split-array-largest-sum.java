class Solution {
    public int splitArray(int[] nums, int k) {
    
        int max = -1;
        int sum = 0;

        if(nums.length < k){
            return -1;
        }

        for(int i=0; i<nums.length; i++){
            sum+= nums[i];
            max = Math.max(max,nums[i]);
        }

        int low = max;
        int high = sum;
        int ans = 0;

        while(low <= high){

            int mid = low + (high-low)/2;

            int m = solve(nums,mid);

            if(m <= k){
                ans = mid;
                high = mid-1;
            }else if(m > k){
              low = mid+1;  
            }
        }

        return ans;
    }

    static int solve(int[] nums, int pages){
        int stu = 1;
        int currpages = 0;

        for(int i=0; i<nums.length; i++){
            if(currpages+nums[i] <= pages){
                currpages += nums[i];
            }else{
                stu++;
                currpages = nums[i];
            }
        }

        return stu;
    }    
}