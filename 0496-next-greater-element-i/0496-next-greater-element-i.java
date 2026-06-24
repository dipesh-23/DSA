class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //Brute force solution O(n1*n2)

        // int[] ans = new int[nums1.length];

        // for(int i=0; i<nums1.length; i++){
        //     int idx = -1;
        //     int tar = nums1[i];
        //     for(int j=0; j<nums2.length; j++){
        //         if(tar == nums2[j]){
        //             idx = j;
        //             break;
        //         }
        //     }
        //     ans[i] = -1;
        //     for(int j=idx; j<nums2.length; j++){
        //         if(nums2[j] > tar){
        //             ans[i] = nums2[j];
        //             break;
        //         }
        //     }
        // }

        // return ans;

        // optimal o(n1+n2)

        int[] nextgreater = new int[10001];
        Stack<Integer> st = new Stack<>();

        for(int i=nums2.length -1; i>=0; i--){

            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }

            nextgreater[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i] = nextgreater[nums1[i]];
        }

        return nums1;


            
    }
}