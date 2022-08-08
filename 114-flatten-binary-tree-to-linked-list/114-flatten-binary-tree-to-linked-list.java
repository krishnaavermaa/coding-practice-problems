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
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root==null) return;
        prev=null;
        func(root);
    }
    public TreeNode func(TreeNode root)
    {
        if(root.left==null && root.right==null)
        {
            prev=root;
            return root;
        }
        TreeNode left=(root.left!=null)?root.left:null;
        TreeNode right=(root.right!=null)?root.right:null;
        if(left!=null) {
            root.left=null;
            root.right=func(left);
        }
        if(right!=null && left!=null) prev.right=func(right);
        else if(right!=null) root.right=func(right);
        return root;
        
    }
}