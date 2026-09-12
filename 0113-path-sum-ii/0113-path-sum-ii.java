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
    public void f(TreeNode root, int target, List<List<Integer>> res, List<Integer> list){

        if(root == null){
            return ;
        }

        list.add(root.val);

        if(root.left == null && root.right == null){
            if(target == root.val){
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        f(root.left,target-root.val,res,list);
        f(root.right,target-root.val,res,list);
        list.remove(list.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


        List<List<Integer>> res = new ArrayList<>();

        f(root,targetSum,res,new ArrayList<>());

        return res;   
    }
}