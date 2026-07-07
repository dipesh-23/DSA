class Solution {
    public int maximumProduct(int[] a, int k) {

        int n = a.length;
        int mod = 1000000000+7;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(a[i]);
        }

        for(int i=0; i<k;i++){
            int minelement = pq.remove();
            minelement++;

            pq.offer(minelement);
        }


        long ans = 1;
        while(!pq.isEmpty()){

            ans *= pq.remove();
            ans = ans%mod;

        }

        return (int)ans;
    }
}