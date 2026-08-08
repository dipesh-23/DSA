class Solution {

    public void f(int index, int sum, List<Integer> list, List<List<Integer>> res,int[] nums){

        if(sum<0 || index == nums.length){
            return;
        }

        if(sum == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        f(index,sum-nums[index],list,res,nums);
        list.remove(list.size()-1);
        f(index+1,sum,list,res,nums);

    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        f(0,target,new ArrayList<>(),res,candidates);

        return res;
    }
}
