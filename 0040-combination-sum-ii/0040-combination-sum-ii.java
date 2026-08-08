class Solution {

    public void f(int index, int sum, List<Integer> list, List<List<Integer>> res,int[] nums,boolean[] visited){

        if(sum == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        if(sum<0 || index == nums.length){
            return;
        }


        for(int i=index; i< nums.length; i++){
            if(i>0 && (nums[i] == nums[i-1]) && visited[i-1] == false){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            f(i+1,sum-nums[i],list,res,nums,visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }

    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];

        
        f(0,target,new ArrayList<>(),res,candidates,visited);

        return res;
    }
}
