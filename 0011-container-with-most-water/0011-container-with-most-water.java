class Solution {
    public int maxArea(int[] height) {
        
        int n = height.length;
        int i=0;
        int j = n-1;
        int max = -1;
        
        while( i<=j){
            int minh = Math.min(height[i],height[j]);
            int b = (j-i);
            long area = 1L* b * minh; 

            max = Math.max(max,(int)area);

            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }

        return max;
    }
}