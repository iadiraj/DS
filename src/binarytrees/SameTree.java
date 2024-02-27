package binarytrees;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }
    public boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p != null && q == null) || (p == null && q != null)) return false;
        boolean left = helper(p.left, q.left);
        boolean right = helper(p.right, q.right);
        return p.val == q.val && left && right;
    }
}
