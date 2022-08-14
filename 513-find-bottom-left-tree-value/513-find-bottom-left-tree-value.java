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
    int res;
    int c;
    public int findBottomLeftValue(TreeNode root) {
        res=0;
        c=-1;
        recurr(root,0);
        return res;
    }
    public void recurr(TreeNode root,int lev)
    {
        if(lev>c) {
            res=root.val;
            c=lev;
        }
        if(root.left!=null) recurr(root.left,lev+1);
        if(root.right!=null) recurr(root.right,lev+1);
    }
}