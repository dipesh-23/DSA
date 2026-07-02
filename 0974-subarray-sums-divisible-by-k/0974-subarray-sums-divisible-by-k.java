class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int i=0;
        int n = nums.length;
        int sum=0;
        int ans = 0;

        while(i< n){
            sum+= nums[i];
            int rem = (k+sum%k)%k;

            if(map.containsKey(rem)){
                ans += map.get(rem);
            }

            map.put(rem,map.getOrDefault(rem,0)+1);
            i++;

        }

        return ans;
        
    }
}
