class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int n = s.length();
        long[] suff = new long[n];

        suff[n-1] = shifts[n-1];
        for(int i=n-2; i>=0; i--){
            suff[i] = suff[i+1]+(long)shifts[i];
        }

        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i<n; i++){
            long shift = suff[i] % 26;
            char ch = (char)((s.charAt(i) - 'a' + shift) % 26 + 'a');
            sb.setCharAt(i, ch);
        }

        return sb.toString();
    } 
}