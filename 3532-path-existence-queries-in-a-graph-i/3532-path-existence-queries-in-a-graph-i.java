class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        boolean[] ans = new boolean[queries.length];

        int comp[] = new int[n];
        int cnt = 0;
        comp[0] = cnt;

        for(int i=1; i<n; i++){
            if((nums[i] - nums[i-1]) <= maxDiff){
                comp[i]= cnt;
            }else{
                cnt++;
                comp[i] = cnt;
            }
        }

        for(int i=0; i<queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            if(comp[u] == comp[v]){
                ans[i] = true;
            }else{
                ans[i] = false;
            }

        }

        return ans;
    }
}