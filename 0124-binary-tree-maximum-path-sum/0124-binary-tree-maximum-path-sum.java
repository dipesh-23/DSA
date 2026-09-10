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
    int ans;
    public int f(TreeNode root){
        if(root == null) return 0;

        int leftsum =  Math.max(0,f(root.left));
        int rightsum = Math.max(0,f(root.right));

        ans = Math.max(root.val+leftsum+rightsum,ans);

        return root.val+Math.max(leftsum,rightsum);
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        int p = f(root);
        return ans;
    }
}