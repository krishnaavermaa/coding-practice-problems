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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null || (root.val==key && root.left==null && root.right==null)) return null;
        find(root,key);
        return root;
    }
    public boolean find(TreeNode root,int key)
    {
        if(root.val==key) {
            del(root);
            return true;
        }
        if(root.left!=null && root.left.val==key && root.left.left==null && root.left.right==null){
            root.left=null;
            return true;
        }
        else if(root.left!=null && find(root.left,key)) return true;
        else if(root.right!=null && root.right.val==key && root.right.left==null && root.right.right==null){
            root.right=null;
            return true;
        }
        else if(root.right!=null && find(root.right,key)) return true;
        return false;
    }
    public void del(TreeNode root)
    {
        if(root.right!=null && root.left==null)
        {
            root.val=root.right.val;
            root.left=root.right.left;
            root.right=root.right.right;
        }
        else if(root.left!=null && root.right==null)
        {
            root.val=root.left.val;
            root.right=root.left.right;
            root.left=root.left.left;
        }
        else if(root.left!=null && root.left.right==null)
        {
            root.val=root.left.val;
            root.left=root.left.left;
        }
        else if(root.right!=null && root.right.left==null)
        {
            root.val=root.right.val;
            root.right=root.right.right;
        }
        else {
            TreeNode p=root,q=root.left;
            while(q.right!=null) {
                p=q;
                q=q.right;
            }
            p.right=q.left;
            root.val=q.val;
        }
    }
}