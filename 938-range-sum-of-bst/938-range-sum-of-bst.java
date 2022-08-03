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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root.left==null && root.right==null) {
            return (root.val>=low && root.val<=high)?root.val:0;
        }
        int left=0,right=0;
        if(root.left!=null && low<root.val) left=rangeSumBST(root.left,low,high);
        if(root.right!=null && high>root.val) right=rangeSumBST(root.right,low,high);
        return (root.val>=low && root.val<=high)?root.val+left+right:left+right;
    }
}