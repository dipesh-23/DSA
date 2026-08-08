class Solution {

    public void f(int index, int[] nums, int target, int k ,List<Integer> list,List<List<Integer>> res){

        if(target == 0){
            if(list.size() == k){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if(target < 0 || index == nums.length){
            return;
        }

        list.add(nums[index]);
        f(index+1,nums,target-nums[index],k,list,res);
        list.remove(list.size()-1);
        f(index+1,nums,target,k,list,res);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];

        for(int i=0; i<9; i++){
            nums[i] = i+1;
        }

        List<List<Integer>> res = new ArrayList<>();

        f(0,nums,n,k,new ArrayList<>(),res);

        return res;

    }
}