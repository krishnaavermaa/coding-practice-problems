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
    String str;
    public String tree2str(TreeNode root) {
        str="";
        recurr(root);
        return str.substring(1,str.length()-1);
    }
    public void recurr(TreeNode root)
    {
        str+="(";
        str+=String.valueOf(root.val);
        if(root.left!=null) recurr(root.left);
        else if(root.right!=null) str+="()";
        if(root.right!=null) recurr(root.right);
        str+=")";
    }
}