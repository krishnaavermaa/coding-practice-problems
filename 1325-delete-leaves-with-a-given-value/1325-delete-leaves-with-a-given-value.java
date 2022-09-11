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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(recurr(root,target)) return root;
        return null;
    }
    public boolean recurr(TreeNode root, int target)
    {
        boolean left=false,right=false;
        if(root.left!=null) left=recurr(root.left,target);
        if(root.right!=null) right=recurr(root.right,target);
        if(root.val==target && !left && !right) return false;
        if(!left) root.left=null;
        if(!right) root.right=null;
        if(root.val!=target) return true;
        return (left || right);
    }
    
    
}