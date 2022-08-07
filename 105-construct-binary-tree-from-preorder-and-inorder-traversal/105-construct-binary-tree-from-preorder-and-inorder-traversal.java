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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pos=0;
        return func(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode func(int[] preorder, int []inorder,int s,int e)
    {
        if(pos>=preorder.length) return null;
        int ele=preorder[pos];
        TreeNode root=new TreeNode(ele);
        for(int i=s;i<=e;i++)
            if(inorder[i]==ele){
                if(i>s){
                    pos++;
                    root.left=func(preorder,inorder,s,i-1);
                }
                if(i<e){
                    pos++;
                    root.right=func(preorder,inorder,i+1,e);
                }
            }
        return root;
    }
}