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
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return root;
        recurr(root,0);
        return root;
    }
    public int recurr(TreeNode root,int sum)
    {
        if(root.right!=null) sum=recurr(root.right,sum);
        root.val+=sum;
        sum=root.val;
        if(root.left!=null) sum=recurr(root.left,sum);
        return sum;
    }
}