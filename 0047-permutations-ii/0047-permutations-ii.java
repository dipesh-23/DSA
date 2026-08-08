class Solution {
    public void f(List<Integer> list, List<List<Integer>> res,int[] nums,boolean[] visited,int explored){

        if(list.size() == nums.length){
            List<Integer> ans = new ArrayList<>();

            for(int i=0; i<list.size(); i++){
                ans.add(nums[list.get(i)]);
            }

            res.add(ans);
            return;
        }

        for(int i=0; i<nums.length; i++){
                
            if(i>0 && nums[i] == nums[i-1]  && visited[i-1] == false){
                     continue;
            }

            if(visited[i] == true) continue;

            list.add(i);
            visited[i] = true;
            f(list,res,nums,visited,explored);
            visited[i] = false;
            list.remove(list.size()-1);
            
        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        boolean[] visited = new boolean[n];
        f(new ArrayList<>(),res,nums,visited,-1);

        return res;
    }
}