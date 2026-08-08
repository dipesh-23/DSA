class Solution {

    public void f(int open, int close,String s, List<String> res ,int n){

        if(open > n || close > n || open < close){
            return;
        }

        if(open == close && s.length() == 2*n){
            res.add(new String(s));
            return;
        }

        f(open+1,close,s+'(',res,n);
        f(open,close+1,s+')',res,n);
    }
   
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        f(0,0,"",res,n);

        return res;
        
    }
}