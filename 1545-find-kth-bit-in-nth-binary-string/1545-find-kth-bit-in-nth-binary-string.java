class Solution {

    public char solve(int n, int k){
        
        int len = (int)Math.pow(2,n)-1;
        int mid = (len+1)/2;
        if (n == 1) {
            return '0';
        }

        if(k < mid){
            char a = solve(n-1,k);
            return a;
        }else if(k > mid){
            char a = solve(n-1,len+1-k);

            if(a == '1'){
                return '0';
            }

            return '1';
        }

        return '1';
    }
    public char findKthBit(int n, int k) {
        
        if(k>1 && (k&(k-1)) == 0){
            return '1';
        }
        return solve(n,k);
    }
}