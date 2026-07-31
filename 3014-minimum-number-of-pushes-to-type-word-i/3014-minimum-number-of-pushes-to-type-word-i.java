class Solution {
    public int minimumPushes(String word) {
        int ans =0;

        for(int i=0; i<word.length(); i++){
            if(i<=7){
                ans++;
            }else if(i<=15){
                ans+=2;
            }else if(i<=23){
                ans+= 3;
            }else{
                ans+= 4;
            }
        }

        return ans;
    }
}