class Solution {
    public int[] nextGreaterElements(int[] arr) {
        
        int[] ans = new int[arr.length];
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int i=2*arr.length-1; i>=0; i--){
            
            while(!st.isEmpty() && st.peek() <= arr[i%n]){
                st.pop();
            }

            if(i < n){
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(arr[i%n]);
        }

        return ans;
    } 
}