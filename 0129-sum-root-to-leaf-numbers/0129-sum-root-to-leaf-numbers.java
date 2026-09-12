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
    public void f(TreeNode root,int numsofar,List<Integer> list){

        if(root.left == null && root.right == null){
            numsofar = numsofar*10+root.val;
            list.add(numsofar);
            return;
        }

        numsofar = numsofar*10+root.val;

        if(root.left != null){

            f(root.left, numsofar,list);
        }

        if(root.right != null){

            f(root.right,numsofar,list);
        }

    }
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        f(root,0,list);

        int sum=0;

        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
        }

        return sum;
    }
}