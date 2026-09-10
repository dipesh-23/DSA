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
    boolean ans;
    public int f(TreeNode root){
        if(root == null){
            return 0;
        }

        int lefth = f(root.left);
        int righth = f(root.right);

        if(Math.abs(lefth-righth)> 1){
            ans = false;
        }

        return 1+Math.max(lefth,righth);
    }
    public boolean isBalanced(TreeNode root) {
        ans = true;
        int p = f(root);
        return ans;
    }
}