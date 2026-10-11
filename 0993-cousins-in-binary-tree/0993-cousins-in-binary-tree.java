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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null)return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int child = 0;
        int parent = 0;

        while(!q.isEmpty()){
            int n = q.size();
            child  = 0;

            for(int i=0; i<n; i++){
                parent = 0;

                TreeNode temper = q.poll();

                if (temper.left != null) {
                    if (temper.left.val == x || temper.left.val == y) {
                        child++;
                        parent++;
                    }
                    q.add(temper.left);
                }

                if (temper.right != null) {
                    if (temper.right.val == x || temper.right.val == y) {
                        child++;
                        parent++;
                    }
                    q.add(temper.right);
                }

                if(parent == 2){
                    return false;
                }
            }

            if(child == 2){
                return true;
            }
            if (child == 1) return false;
        }

        return false;
    }
}