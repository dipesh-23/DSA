class Solution {
    public long sumAndMultiply(int n) {
        
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        long sum= 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '0'){
                sum+= s.charAt(i)-'0';
                sb.append(s.charAt(i));
            }
        }

        if(sb.length() == 0){
            return 0L;
        }

        long x = Long.parseLong(sb.toString());
        x = x*sum;

        return x;
    }
}