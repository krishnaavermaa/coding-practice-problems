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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        return inorder(root,k,set);
    }
    public boolean inorder(TreeNode root,int k, Set<Integer> set)
    {
        if(root.left!=null) if(inorder(root.left,k,set)) return true;
        if(set.contains(root.val)) return true;
        else set.add(k-root.val);
        if(root.right!=null) if(inorder(root.right,k,set)) return true;
        return false;
    }
}