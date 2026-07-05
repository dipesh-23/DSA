/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return f(root,p,q);
    }

    public static TreeNode f(TreeNode root, TreeNode p, TreeNode q){

        if(root == null){
            return null;
        }

        if(root == p ){
            return p;
        }

        if(root == q){
            return q;
        }

        TreeNode left = f(root.left,p,q);
        TreeNode right = f(root.right,p,q);

        if(left != null && right != null){
            return root;
        }

        if(left != null){
            return left;
        }else if(right != null){
            return right;
        }else{
            return null;
        }

    }
}