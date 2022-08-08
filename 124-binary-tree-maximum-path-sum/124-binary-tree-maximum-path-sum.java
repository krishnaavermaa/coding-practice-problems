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
    int max;
    public int maxPathSum(TreeNode root) {
        max=-1001;
        int tmp=recurr(root);
        if(tmp>max) max=tmp;
        return max;
    }
    public int recurr(TreeNode root)
    {
        if(root.left==null && root.right==null) 
        {
            if(root.val>max) max=root.val;
            return root.val;
        }
        if(root.val>max) max=root.val;
        int left=-1001,right=-1001;
        int sum=root.val;
        if(root.left!=null) {
            left=recurr(root.left);
            sum+=left;
        }
        if(left+root.val>max) max=left+root.val;
        if(root.right!=null) {
            right=recurr(root.right);
            sum+=right;
        }
        if(right+root.val>max) max=right+root.val;
        if(sum>max) max=sum;
        sum= (left+root.val>=right+root.val)?left+root.val:right+root.val;
        sum= (sum>root.val)?sum:root.val;
        if(sum>max) max=sum;
        return sum;
    }
    
}