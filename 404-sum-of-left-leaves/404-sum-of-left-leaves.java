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
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum=0;
        func(root,root);
        return sum;
    }
    public void func(TreeNode node, TreeNode prev)
    {
        if(node.left==null && node.right==null && prev.left==node){
            sum+=node.val;
            return;
        }
        if(node.left!=null) func(node.left,node);
        if(node.right!=null) func(node.right,node);
    }
}