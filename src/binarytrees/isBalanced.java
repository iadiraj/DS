package binarytrees;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }
public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        boolean[] isBal = new boolean[1];
        isBal[0] = true;
        int temp = helper(root, isBal);
        return isBal[0];
    }
    public int helper(TreeNode node, boolean[] isBalanced) {
        if(node == null) return 0;
        int left = 0;
        int right = 0;
        if(node.left != null) {
            left = helper(node.left, isBalanced);
        }
        if(node.right != null) {
            right = helper(node.right, isBalanced);
        }
        if(isBalanced[0]) {
            isBalanced[0] = Math.abs(left - right) <= 1;
        }
        return 1 + Math.max(left, right);
    }
}
