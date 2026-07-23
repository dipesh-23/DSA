class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        int n = nums.length;

        if(n<=2) return n; 

        int pos = 31 - Integer.numberOfLeadingZeros(n);

        return (int)Math.pow(2,pos+1);

    }
}