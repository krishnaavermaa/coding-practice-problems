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
    public boolean isUnivalTree(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        if(root.left!=null && (!isUnivalTree(root.left) || root.val!=root.left.val)) return false;
        if(root.right!=null && (!isUnivalTree(root.right) || root.val!=root.right.val)) return false;
        return true;
    }
}