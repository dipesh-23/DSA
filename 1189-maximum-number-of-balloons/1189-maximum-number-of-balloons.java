class Solution {
    public int maxNumberOfBalloons(String s) {
        
        int[] freq = new int[26];
        int n = s.length();

        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }

        int min = 100000;
        min= Math.min(min,freq['b'-'a']);
        min = Math.min(min,freq['a'-'a']);
        min = Math.min(min,freq['l'-'a']/2);
        min = Math.min(min,freq['o'-'a']/2);
        min = Math.min(min,freq['n'-'a']);

        return min;
    }
}