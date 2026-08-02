class Solution {
    public boolean checkOnesSegment(String s) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            if(sb.charAt(sb.length() -1) != s.charAt(i)){
                sb.append(s.charAt(i));
            }
        }

        String p = sb.toString();
        int cnt = 0;
        
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '1'){
                cnt++;
            }
        }

        return (cnt <=1)? true: false;
    }
}