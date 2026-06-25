class Solution {
    public long subArrayRanges(int[] arr) {

       //Brute solution O(N^2) 
        // long ans = 0;
        // int n = nums.length;

        // for(int i=0; i<n; i++){
        //     int max = Integer.MIN_VALUE;
        //     int min = Integer.MAX_VALUE;
        //     for(int j=i; j<n; j++){
        //         min = Math.min(min,nums[j]);
        //         max = Math.max(max,nums[j]);

        //         ans += (max-min);
        //     }
        // }

        // return ans;


        // After seeing maximum and minimum element in subarray you should get a feeling of stack to solve the question in Linear time.If the question is about subarray u can never sort the array

        int n = arr.length;
        long min[] = new long[n];
        long max[] = new long[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            int next = st.isEmpty() ? n : st.peek();
            st.push(i);
            min[i] = (next-i);
        }

        st.clear();
        for(int i=0; i<n; i++){
            
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            int prev = st.isEmpty()? -1 : st.peek();
            st.push(i);
            min[i] *= (i-prev);
        }

        st.clear();
        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }

            int next = st.isEmpty() ? n : st.peek();
            st.push(i);
            max[i] = (next-i);
        }

        st.clear();
        for(int i=0; i<n; i++){
            
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }

            int prev = st.isEmpty()? -1 : st.peek();
            st.push(i);
            max[i] *= (i-prev);
        }

        long res = 0;

        for(int i=0; i<n; i++){
            res -= (min[i]*(long)arr[i]);
            res += (max[i] * (long)arr[i]);
        }

        return res;

    }
}