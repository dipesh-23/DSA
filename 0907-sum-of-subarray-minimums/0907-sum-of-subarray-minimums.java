import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {

        int mod = 1000000007;
        int n = arr.length;

        long[] ans = new long[n];
        Stack<Integer> st = new Stack<>();

        // Next Less or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            int next = st.isEmpty() ? n : st.peek();
            ans[i] = next - i;
            st.push(i);
        }

        st.clear();

        // Previous Less (strict)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            int prev = st.isEmpty() ? -1 : st.peek();
            ans[i] *= (i - prev);
            st.push(i);
        }

        long res = 0;

        for (int i = 0; i < n; i++) {
            res = (res + (ans[i] * arr[i]) % mod) % mod;
        }

        return (int) res;
    }
}