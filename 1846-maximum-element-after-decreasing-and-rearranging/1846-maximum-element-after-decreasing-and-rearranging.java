class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        
        Arrays.sort(arr);

        int n = arr.length;
        int max = arr[n-1];
        if(n==1){
            max = 1;
        }
        for(int i=0; i<n-1; i++){

            if(i==0 && arr[i] != 1){
                arr[i] = 1;
            }
            if(arr[i+1] -arr[i] <=1){
                continue;
            }else{
                arr[i+1] = arr[i]+1;
            }
            max = arr[i+1];
        }

        return max;
    }
}