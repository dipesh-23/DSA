import java.util.*;
class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        return gcd(nums[0],nums[nums.length-1]);
    }

    int gcd(int a,int b){
        
        if(a==0 || b==0) return a^b;

        return gcd(b,a%b);
    }

}