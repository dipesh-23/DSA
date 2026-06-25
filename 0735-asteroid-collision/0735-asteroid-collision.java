class Solution {
    public int[] asteroidCollision(int[] a) {
        
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        st.push(a[n-1]);

        for(int i=n-2; i>=0; i--){

            boolean destroyed = false;

                while(!st.isEmpty() && st.peek() < 0 && a[i] > 0){
                    if(Math.abs(st.peek()) > Math.abs(a[i])){
                        destroyed = true;
                        break;
                    }else if(Math.abs(st.peek()) < Math.abs(a[i])){
                        st.pop();
                    }else{
                        destroyed = true;
                        st.pop();
                        break;
                    }
                }

                if(!destroyed){
                    st.push(a[i]);
                }
                
        }

        int[] ans = new int[st.size()];
        int i=0;
        while(!st.isEmpty()){
            
            ans[i++] = st.pop();
        }

        return ans;
    }
}