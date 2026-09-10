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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        List<List<TreeNode>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            List<TreeNode> list = new ArrayList<>();
            while(!q.isEmpty()){
                list.add(q.poll());
            }
            ans.add(list);
            for(int i=0; i<list.size(); i++){
                if(list.get(i).left != null){
                    q.offer(list.get(i).left);
                }

                if(list.get(i).right != null){
                    q.offer(list.get(i).right);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<ans.size(); i++){
            res.add(new ArrayList<>());
        }

        for(int i=0; i<ans.size(); i++){
            for(int j=0; j<ans.get(i).size(); j++){
                res.get(i).add(ans.get(i).get(j).val);
            }
        }

        return res;
    }
}