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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return searchBST(root,val);
    }
    public TreeNode searchBST(TreeNode root, int val)
    {
        if(root==null) return new TreeNode(val);
        int curr=root.val;
        if(val<curr) root.left=searchBST(root.left,val);
        if(val>curr) root.right=searchBST(root.right,val);
        return root;
    }
}