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
    int dia ;
    public int f(TreeNode root){
        if(root == null ){
            return 0;
        }

        int lefth = f(root.left);
        int righth = f(root.right);

        dia = Math.max(dia, lefth+righth);

        return 1+Math.max(lefth,righth);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        int p = f(root);
        return dia;
    }
}