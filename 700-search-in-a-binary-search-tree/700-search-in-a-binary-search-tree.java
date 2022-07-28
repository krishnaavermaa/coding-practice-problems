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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val==val) return root;
        if(root.left==null && root.right==null) return null;
        TreeNode l=null,r=null;
        if(root.left!=null) l=searchBST(root.left,val);
        if(l!=null) return l;
        if(root.right!=null) r=searchBST(root.right,val);
        if(r!=null) return r;
        return null;
    }
}