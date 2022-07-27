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
    public int findSecondMinimumValue(TreeNode root) {
        int res=func(root.val,root);
        return res!=root.val?res:-1;
    }
    public int func(int rootval, TreeNode node)
    {
        if(node.left==null && node.right==null) return node.val;
        int l=-1,r=-1,res=-1;
        if(node.left.val!=node.right.val) {
            l=node.left.val;
            r=node.right.val;
            if(l<r && l==rootval) l=func(rootval,node.left);
            else if(r<l && r==rootval) r=func(rootval,node.right);
            if(l!=rootval && r!=rootval)
            {
                if(l==-1||r==-1) return l!=-1?l:r;
                return l<r?l:r;
            }
            else return l!=rootval?l:r;
        }
        else
        {
            l=func(rootval,node.left);
            r=func(rootval,node.right);
            if(l==r) return -1;
            if(l!=rootval && r!=rootval)
            {
                if(l==-1 || r==-1) return l!=-1?l:r;
                return l<r?l:r;
            }
            else return l!=rootval?l:r;
        }
        
    }
}