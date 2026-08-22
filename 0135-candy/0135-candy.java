class Solution {
    public int candy(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n];

        Arrays.fill(arr,1);
        int ans = 0;

        for(int i=0; i<n-1; i++){
            if(nums[i+1] > nums[i]){
                arr[i+1] = arr[i]+1;
            }
        }

        for(int i=n-1; i>0; i--){
            if(nums[i-1] > nums[i]){
                arr[i-1] = Math.max(arr[i-1],arr[i]+1);
            }
        }
        
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }

        return sum;
    }
}