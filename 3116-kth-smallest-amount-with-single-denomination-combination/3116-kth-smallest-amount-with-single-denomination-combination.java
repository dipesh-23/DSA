class Solution {

    public long gcd(long a, long b){

        if(b==0) return a;
        return gcd(b,a%b);
    }

    public long countnums(long mid, int[] nums){

        int n = nums.length;
        long result = 0;
        for(int exp=1; exp<= (1<<n)-1; exp++ ){

            long lcm =0;
            long order =0;
            for(int i=0; i < n; i++){

                if((exp&(1<<i)) != 0){
                    order++;

                    if(lcm == 0){
                        lcm = nums[i];
                    }else{
                        lcm = (lcm /gcd(lcm,nums[i]))*nums[i];
                    }
                }
            }

            if(order%2==0){
                result -= (mid/lcm);
            }else{
                result += (mid/lcm);
            }
        }

        return result;
    }
    public long findKthSmallest(int[] nums, int k) {
        
        long max = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            max = Math.max(max,(long)nums[i]*k);
        }

        long l=1;
        long r = max;
        long res=0;

        while(l<=r){

            long mid = l+(r-l)/2;

            if(countnums(mid,nums) >= k){
                res = mid;
                r = mid-1;
            }else{
                l= mid+1;
            }
        }

        return res;
    }
}