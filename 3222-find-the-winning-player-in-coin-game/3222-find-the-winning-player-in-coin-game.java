class Solution {
    public String winningPlayer(int x, int y) {
        
        if(x >= y){
            int p = y/4;
            if(p%2 == 0){
                return "Bob";
            }else{
                return "Alice";
            }
        }else{
            if(x*4 > y){
                int p = y/4;
                if(p%2 == 0){
                    return "Bob";
                }else{
                    return "Alice";
                }  
            }else{
                if(x%2 == 0){
                    return "Bob";
                }else{
                    return "Alice";
                }  
            }
        }
    }
}