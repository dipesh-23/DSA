class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int  m = rolls.length;

        int sum = 0;
        for(int i=0; i<rolls.length; i++){
            sum += rolls[i];
        }

        int remain = (n+m)*mean-sum;

        if(remain < n || remain > n*6){
            return new int[]{};
        }

        int[] arr = new int[n];
        int v = remain/n;
        int mod = remain%n;

        Arrays.fill(arr,v);
        int i=0;
        while(mod != 0){
            arr[i]++;
            i++;
            mod--;
        }

        return arr;
    }
}