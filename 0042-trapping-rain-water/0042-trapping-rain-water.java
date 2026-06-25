class Solution {
    public int trap(int[] height) {
        // Brute solution T.C = O(3n) S.c = O(2n)
        // int n = height.length;
        // int[] lmax = new int[n];
        // int[] rmax = new int[n];

        // lmax[0] = 0;
        // for(int i=1; i<n; i++){
        //     lmax[i] = Math.max(lmax[i-1],height[i-1]);
        // }

        // rmax[n-1]= 0;
        // for(int i=n-2; i>=0 ;i--){
        //     rmax[i] = Math.max(rmax[i+1],height[i+1]);

        // }

        // int ans = 0;
        // for(int i=0; i<n; i++){
        //     if(height[i] <= lmax[i] && height[i] <= rmax[i]){
        //         ans+= Math.min(lmax[i],rmax[i])-height[i];
        //     }
        // } 

        // return ans;


        //optimal soln space optimized

        int l = 0;
        int r = height.length-1;
        int lmax =0;
        int rmax = 0;
        int ans = 0;

        while(l < r){

            if(height[r] >= height[l]){
                if(lmax > height[l]){
                    ans += (lmax-height[l]);
                }
                lmax = Math.max(lmax,height[l]);
                l++; 
            }else{
                if(rmax > height[r]){
                    ans+= (rmax-height[r]);
                }
                rmax = Math.max(rmax,height[r]);
                r--;
            }
        }

        return ans;


    }
}