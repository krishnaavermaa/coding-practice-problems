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
    List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        list=new LinkedList<>();
        paths(root,"");
        return list;
    }
    public void paths(TreeNode node,String str)
    {
        if(str=="") str+=String.valueOf(node.val);
        else str+="->"+String.valueOf(node.val);
        if(node.left!=null) paths(node.left,str);
        if(node.right!=null) paths(node.right,str);
        if(node.left==null && node.right==null) {list.add(str);}
        
    }
}