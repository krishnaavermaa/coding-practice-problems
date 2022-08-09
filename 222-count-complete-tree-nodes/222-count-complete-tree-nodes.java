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
    int height;
    int last;
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        height=-1;
        last=0;
        recurr(root,0);
        // return (int)Math.pow(2,height-1)+last;
        int sum=0;
        for(int i=0;i<height;++i)
            sum+=(int)Math.pow(2,i);
        return sum+last;
    }
    public boolean recurr(TreeNode root,int c)//lasLevelcount
    {
        if(root.left==null && root.right==null)
        {
            if(height==-1) height=c;
            if(c<height) return false;
            last++;
            return true;
        }
        if(root.left!=null && !recurr(root.left,c+1)) return false;
        if(root.right!=null && !recurr(root.right,c+1)) return false;
        return true;
    }
}