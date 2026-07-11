class Solution {

    static int nodes;
    static int e;
    public void dfs(int node , List<List<Integer>> adj,boolean[] visited){
        visited[node] = true;
        nodes++;
        e+= adj.get(node).size();

        for(int neighbour : adj.get(node)){

            if(!visited[neighbour]){
                dfs(neighbour,adj,visited);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int cnt = 0;

        for(int i=0; i<n; i++){
            nodes = 0;
            e = 0;
            if(!visited[i]){
                dfs(i,adj,visited);
                e = e/2;
                if( e == ((nodes)*(nodes-1))/2){
                    cnt++;
                }
                
            }
        }

        return cnt;

    }
}