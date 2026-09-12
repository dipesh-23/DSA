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
    public void f(TreeNode root,String s,List<String> list){

        if(root == null) return;

        
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder(s);
            sb.append((char)(root.val+97));
            sb.reverse();
            list.add(sb.toString());
            return;
        }

        f(root.left,s+(char)(97+root.val),list);
        f(root.right,s+(char)(97+root.val),list);
    }
    public String smallestFromLeaf(TreeNode root) {
        
        List<String> list = new ArrayList<>();
        f(root,"",list);

        Collections.sort(list);
        return list.get(0);
    }
}