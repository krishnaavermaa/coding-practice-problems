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
    int min;
    TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        min=Integer.MAX_VALUE;
        prev=null;
        recurr(root);
        return min;
    }
    public void recurr(TreeNode root)
    {
        if(root.left==null && root.right==null) {
            if(prev!=null) min=min<=root.val-prev.val?min:root.val-prev.val;
            prev=root;
            return;
        }
        if(root.left!=null) recurr(root.left);
        if(prev!=null) min=min<=root.val-prev.val?min:root.val-prev.val;
        prev=root;
        if(root.right!=null) recurr(root.right);
    }
}