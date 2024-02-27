package binarytrees;

public class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        int temp = helper(root, max);
        return max[0];
    }
    public int helper(TreeNode node, int[] max){
        if(node == null) return 0;
        int left = 0;
        int right = 0;
        if(node.left != null) {
            left = Math.max(0, helper(node.left, max));
        }
        if(node.right != null) {
            right = Math.max(0, helper(node.right, max));
        }
        max[0] = Math.max(max[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
