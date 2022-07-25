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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        if(root==null) return list;
        func(root,list);
        return list;
    }
    public void func(TreeNode root, List<Integer> list)
    {
        if(root.left!=null) func(root.left,list);
        if(root.right!=null) func(root.right,list);
        list.add(root.val);
    }
}