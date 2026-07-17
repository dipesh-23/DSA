class Solution {
    boolean pathvisited[];
    public boolean canFinish(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i< edges.length; i++){
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean visited[] = new boolean[V];
        boolean ans = true;
        pathvisited = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
               if(cycle(i,visited,adj) == true){
                   return false;
               }
            }
        }
        
        return true;
    }
    
    public boolean cycle(int node, boolean[] visited,ArrayList<ArrayList<Integer>> adj ){
        
        visited[node] = true;
        pathvisited[node] = true;
        boolean ans = false;
        
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                ans = ans || cycle(neighbour,visited,adj);
            }else if(visited[neighbour] == true && pathvisited[neighbour] == true){
                return true;
            }
        }
        
        pathvisited[node]=false;
        return ans;
    }
}