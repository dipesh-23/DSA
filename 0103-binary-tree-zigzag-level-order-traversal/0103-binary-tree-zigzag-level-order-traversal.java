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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<n; i++){
                TreeNode temp = q.poll();
                list.add(temp.val);

                if(temp.left != null){
                    q.offer(temp.left);
                }

                if(temp.right != null){
                    q.offer(temp.right);
                }
            }

            if(flag == false){
                Collections.reverse(list);
            }
            flag = flag^true;
            res.add(list);
        }

        return res;
    }
}