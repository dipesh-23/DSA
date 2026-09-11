class Solution {

    public boolean f(TreeNode root, int target) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return target == root.val;
        }

        boolean lefty = f(root.left, target - root.val);
        boolean righty = f(root.right, target - root.val);

        return lefty || righty;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        return f(root, targetSum);
    }
}