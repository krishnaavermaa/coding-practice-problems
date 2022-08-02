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
    TreeNode prev;
    TreeNode head;
    public TreeNode increasingBST(TreeNode root) {
        prev=null;
        head=null;
        func(root);
        return head;
    }
    public void func(TreeNode root)
    {
        TreeNode left=root.left,right=root.right;
        if(left==null && right==null) {
            if(prev!=null){
                prev.left=null;
                prev.right=root;
                prev=root;
            }
            else {
                prev=root;
                head=root;
            }
            return;
        }
        
        if(left!=null) {
            root.left=null;
            func(left);
        }
        if(prev!=null) {
            prev.left=null;
            prev.right=root;
            prev=root;
        }
        else {
            prev=root;
            head=root;
            prev.left=null;
            prev.right=null;
        }
        if(right!=null) {
            root.right=null;
            func(right);
        }
    }
}