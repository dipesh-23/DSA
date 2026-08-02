class Solution {
    public String reversePrefix(String s, char ch) {
        
        StringBuilder sb = new StringBuilder(s);

        int idx = s.indexOf(ch);
        if(idx == -1){
            return sb.toString();
        }
            String sub = s.substring(0,idx+1);
            StringBuilder str = new StringBuilder(sub).reverse();
            return str.toString()+s.substring(idx+1);

    }
}