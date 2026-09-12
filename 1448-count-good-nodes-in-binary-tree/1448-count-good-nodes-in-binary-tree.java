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
    public void f(TreeNode root,int max){
        if(root == null){
            return;
        }

        if(root.val >= max){
            ans++;
        }

        f(root.left,Math.max(max,root.val));
        f(root.right,Math.max(max,root.val));
    }
    public int goodNodes(TreeNode root) {
        
        ans=0;
        f(root,root.val);
        return ans;
    }
}