class Solution {
    public int maxValidPairSum(int[] a, int k) {

        int n = a.length;
        int[] pref = new int[n];
        int[] suff = new int[n];

        for(int i=0; i<n; i++){
            pref[i] = Integer.MIN_VALUE/2;
            suff[i] = Integer.MIN_VALUE/2;
        }

        for(int i=k;i<n; i++){
            pref[i] = Math.max(pref[i-1],a[i-k]);
        }

        for(int i=n-k-1; i>=0; i--){
            suff[i] = Math.max(suff[i+1],a[i+k]);
        }

        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, Math.max(pref[i] ,suff[i])+a[i]);
        }

        return max;

        
    }
}