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

    int sum =0;
    public boolean isLeaf(TreeNode root){

        if(root == null) return false;
        if(root.left == null && root.right == null){
            return true;
        }

        return false;
    }


    public void f(TreeNode root){

        if(root == null) return;

        if(isLeaf(root.left) == false){
            f(root.left);
        }

        if(isLeaf(root.left) == true){
            sum+= root.left.val;
        }

        f(root.right);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        
        sum=0;
        f(root);

        return sum;
    }
}