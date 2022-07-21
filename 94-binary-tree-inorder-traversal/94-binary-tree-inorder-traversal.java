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
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list=new LinkedList<>();
        if(root!=null) traverse(root);
        return list;
    }
    public void traverse(TreeNode ptr)
    {
        if(ptr.left!=null) traverse(ptr.left);
        list.add(ptr.val);
        if(ptr.right!=null) traverse(ptr.right);
    }
}