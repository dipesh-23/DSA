class Solution {

    static long count = 0;
    public long countMajoritySubarrays(int[] nums, int target) {
        
        int n = nums.length;
        long[] pre = new long[n+1];

        for(int i=0; i<n ; i++){

            if(target == nums[i]){
                pre[i+1]= 1;
            }else{
                pre[i+1] = -1;
            }
        }

        for(int i=1; i<n+1; i++){
            pre[i] += pre[i-1];
        }

        count = 0;
        mergesort(0,n,pre);

        return count;

    }

    public static void mergesort(int low, int high,long[] nums){

        if(low >= high){
            return;
        }

        int mid = low+(high-low)/2;
        mergesort(low,mid,nums);
        mergesort(mid+1,high,nums);

        merge(low,mid,high,nums);
    }


    public static void merge(int low, int mid, int high,long[] nums){

        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();

        for(int i=low; i<=mid; i++){
            list1.add(nums[i]);
        }

        for(int j=mid+1; j<=high; j++){
            list2.add(nums[j]);
        }

        int i=0;
        int j= 0;
        List<Long> ans = new ArrayList<>();
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                count+= (list2.size()-j);
                ans.add(list1.get(i));
                i++;
            }else{
                ans.add(list2.get(j));
                j++;
            }
        }

        while(i < list1.size()){
            ans.add(list1.get(i));
            i++;
        }

        while(j < list2.size()){
            ans.add(list2.get(j));
            j++;
        }

        for(int p=0; p<ans.size(); p++){
            nums[low+p] = ans.get(p);
        }
    }
}