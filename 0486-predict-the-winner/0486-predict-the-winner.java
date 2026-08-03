class Solution {
    public int f(int i, int j, int[] nums,int turn){
          
        if(i>j) return 0;

        if(turn == 0){
            int score1 = nums[i]+f(i+1,j,nums,turn^1);
            int score = nums[j]+f(i,j-1,nums,turn^1);

            return Math.max(score1,score);
        }else{
            int score1 = f(i+1,j,nums,turn^1);
            int score = f(i,j-1,nums,turn^1);

            return Math.min(score1,score);
        }
    }


    public boolean predictTheWinner(int[] nums) {

        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        
        int s1 = f(0,nums.length-1,nums,0);
        int s2 = sum-s1;

        return (s1>=s2)? true : false;
    }
}