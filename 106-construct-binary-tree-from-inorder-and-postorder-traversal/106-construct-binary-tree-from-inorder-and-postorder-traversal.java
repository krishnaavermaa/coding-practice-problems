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
    int pos;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pos=postorder.length-1;
        return buildSubtree(postorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildSubtree(int[] postorder,int[] inorder, int s,int e)
    {
        if(pos<0) return null;
        int ele=postorder[pos];
        TreeNode root=new TreeNode(ele);
        for(int i=0;i<inorder.length;i++)
            if(inorder[i]==ele){
                if(i<e){
                    pos--;
                    root.right=buildSubtree(postorder,inorder,i+1,e);
                }
                if(i>s){
                    pos--;
                    root.left=buildSubtree(postorder,inorder,s,i-1);
                }
                break;
            }
        return root;
    }
}