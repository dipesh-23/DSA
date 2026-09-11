class Solution {

    public void f(int[] nums,List<Integer> list, Set<List<Integer>> set,boolean[] used){

        if(list.size() == 3){
            if((list.get(2)%2 == 0) && (list.get(0) != 0)){
                set.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;

            used[i] = true;
            list.add(nums[i]);
            f(nums,list,set,used);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
    
    public int totalNumbers(int[] digits) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        f(digits,list,set,new boolean[digits.length]);

        return set.size();
        
    }
}