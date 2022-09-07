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
    public int distributeCoins(TreeNode root) {
        res=0;
        func(root);
        return res;
    }
    public int func(TreeNode root)
    {
        int left=0,right=0;
        if(root.left!=null) left=func(root.left);
        if(root.right!=null) right=func(root.right);
        res+=Math.abs(left)+Math.abs(right);
        return root.val+left+right-1;
        
    }
}