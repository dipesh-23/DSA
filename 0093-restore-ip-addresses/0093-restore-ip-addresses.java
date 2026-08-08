class Solution {
    
    public boolean isValid(String s){

        if(s.charAt(0) == '0' && s.length() > 1){
            return false;
        }

        int n = Integer.parseInt(s);
        if(n > 255){
            return false;
        }

        return true;
    }
    
    public void f( int index, String ans, String s,int parts, List<String> list){

        if(parts >5){
            return;
        }

        if(parts == 4 && index == s.length()){
            list.add(new String(ans.substring(0,ans.length()-1)));
            return;
        }

        for(int i=index; i<Math.min(s.length(),index+3) ; i++){
            if(isValid(s.substring(index,i+1)) == true){
                f(i+1,ans+s.substring(index,i+1)+'.',s,parts+1,list);
            }
        }

    }
    public List<String> restoreIpAddresses(String s) {
        
        List<String>  list = new ArrayList<>();
        if(s.length()<=3 || s.length() > 12){
            return list;
        }

        f(0,"",s,0,list);
        return list;
    }
}