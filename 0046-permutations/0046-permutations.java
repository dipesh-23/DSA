class Solution {

    public static void f(List<Integer> list , List<List<Integer>> res,int[] nums){

        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            f(list,res,nums);
            list.remove(list.size()-1);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        f(new ArrayList<>(),res,nums);

        return res;
        
    }
}