class Solution {
    class Pair{
        int f ;
        int s;

        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }

    static int min = 0;

    public static void dfs(int node,boolean[] visited, ArrayList<ArrayList<Pair>> adj){

        visited[node] = true;

        for(Pair neighbour : adj.get(node)){
            int first = neighbour.f;
            int dist = neighbour.s;
            min = Math.min(min,dist);

            if(!visited[first]){
                dfs(first,visited,adj);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<roads.length; i++){
            int u = roads[i][0]-1;
            int v = roads[i][1]-1;
            int dist = roads[i][2];

            adj.get(u).add(new Pair(v,dist));
            adj.get(v).add(new Pair(u,dist));
        }

        boolean[] visited = new boolean[n];
        min = Integer.MAX_VALUE;

        dfs(0,visited,adj);

        return min;
        
    }
}