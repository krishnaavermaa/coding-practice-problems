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
    public int getMinimumDifference(TreeNode root) {
        min=Integer.MAX_VALUE;
        prev=null;
        func(root);
        return min;
    }
    public void func(TreeNode root)
    {
        if(root.left!=null) func(root.left);
        int diff;
        if(prev!=null)
        {
           diff=Math.abs(prev.val-root.val);
        }
        else diff=Integer.MAX_VALUE;
        prev=root;
        min=min<=diff?min:diff;
        if(root.right!=null) func(root.right);
    }
}