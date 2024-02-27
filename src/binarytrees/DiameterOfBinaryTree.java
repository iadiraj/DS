package binarytrees;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
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
            left = helper(node.left, max);
        }
        if(node.right != null) {
            right = helper(node.right, max);
        }
        max[0] = Math.max(max[0], left+right);
        return 1 + Math.max(left, right);
    }
}
