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
    int l;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        if(root==null) return list;
        l=-1;
        rightView(root,list,0);
        return list;
    }
    public void rightView(TreeNode root,List<Integer> list,int c)
    {
        if(c>l) {
            list.add(root.val);
            l=c;
        }
        if(root.right!=null) rightView(root.right,list,c+1);
        if(root.left!=null) rightView(root.left,list,c+1);
    }
}