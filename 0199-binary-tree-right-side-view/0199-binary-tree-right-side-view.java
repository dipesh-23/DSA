/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode>  q =new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            int n = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i=0; i<n; i++){
                TreeNode temp = q.poll();
                l.add(temp.val);

                if(temp.left != null){
                    q.offer(temp.left);
                }

                if(temp.right != null){
                    q.offer(temp.right);
                }
            }

            list.add(l);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            res.add(list.get(i).get(list.get(i).size()-1));
        }

        return res;
    }
}