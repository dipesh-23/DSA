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

    int ans  = 0;
    public int[] f(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int[] left = f(root.left);
        int[] right = f(root.right);

        int count = left[1]+right[1]+1;
        if((root.val+left[0]+right[0])/count == root.val){
            ans++;
        }
        return  new int[]{root.val+ left[0] + right[0],count};
    }
    public int averageOfSubtree(TreeNode root) {
        
        ans = 0;
        int[] p = f(root);

        return ans;
    }
}