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
    public int longestZigZag(TreeNode root) {
        if(root.left==null && root.right==null) return 0;
        res=0;
        if(root.left!=null) recurr(root.left,0,-1);
        if(root.right!=null) recurr(root.right,0,1);
        return res;
    }
    public void recurr(TreeNode root,int c,int d)
    {
        c++;
        if(d==-1)
        {
            if(root.right!=null) recurr(root.right,c,d*-1);
            else if(c>res) res=c;
            if(root.left!=null) recurr(root.left,0,d);
        }
        else if(d==1)
        {
            if(root.left!=null) recurr(root.left,c,d*-1);
            else if(c>res) res=c;
            if(root.right!=null) recurr(root.right,0,d);
        }
    }
}