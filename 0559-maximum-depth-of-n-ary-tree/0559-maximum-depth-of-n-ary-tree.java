/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int f(Node root){
        if(root == null){
            return 0;
        }

        List<Node> temp = root.children;
        int height = 0;
        for(int i=0; i< temp.size(); i++){
           height =  Math.max(height,f(temp.get(i)));
        }

        return 1+height;
    }
    public int maxDepth(Node root) {
        
        return f(root);
    }
}