import java.util.*;
class Solution {
    public static void f(int index, int[] nums, List<Integer> list, List<List<Integer>> res){

        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        f(index+1,nums,list,res);
        list.remove(list.size()-1);
        f(index+1,nums,list,res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        f(0,nums,new ArrayList<>(),res);

        return res;
        
    }
}