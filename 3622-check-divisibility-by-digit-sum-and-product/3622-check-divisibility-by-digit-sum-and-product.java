class Solution {
    public boolean checkDivisibility(int n) {
        
        int sum = 0;
        int product = 1;
        int y =n;

        while(n >0){
            int digit = n%10;
            sum += digit;
            product = product*digit;
            n = n/10;
        }

        if(y%(sum+product) == 0){
            return true;
        }

        return false;
    }
}