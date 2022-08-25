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
    int longest;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        longest=0;
        int tmp=recurr(root);
        if(tmp>longest) longest=tmp;
        return longest;
    }
    public int recurr(TreeNode root)
    {
        int lval=0,rval=0;
        TreeNode left=root.left,right=root.right;
        if(left!=null) lval=recurr(left);
        if(right!=null) rval=recurr(right);
        if(left!=null && right!=null && left.val==right.val && root.val==left.val)
        {
            if(lval+rval+2>longest) longest=lval+rval+2;
            return Math.max(lval,rval)+1;
        }
        if(left!=null && left.val==root.val) {
            if(rval>longest) longest=rval; 
            return lval+1;
        }
        if(right!=null && right.val==root.val) {
            if(lval>longest) longest=lval;
            return rval+1;
        }
        if(lval>longest) longest=lval;
        if(rval>longest) longest=rval;
        return 0;
    }
    
}