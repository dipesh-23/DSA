class Solution {
    public boolean xorGame(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int xor = 0;

        for(int i=0; i<n; i++){
            xor = xor^nums[i];
        }

        if(xor == 0){
            return true;
        }

        for(int i=0; i<n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Integer value : map.values()){
            if(value%2 == 1){
                value = 1;
            }
        }

       map.entrySet().removeIf(entry -> entry.getValue() % 2 == 0);
        if(map.size()%2 == 1){
            return false;
        }

        return true;
        
    }
}