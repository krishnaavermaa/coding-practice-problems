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
    int res;
    TreeNode head;
    public int minCameraCover(TreeNode root) {
        res=0;
        head=root;
        if(recurr(root)==0) res++;
        return res;
    }
    public int recurr(TreeNode root)
    {
        int left=-1,right=-1;
        if(root.left!=null) left=recurr(root.left);
        if(root.right!=null) right=recurr(root.right);
        if(root.left==null && root.right==null)
        {
            if(root!=head) return 0;
            else{
                res++;
                return 2;
            }
        }
        else if(left==0 || right==0)
        {
            res++;
            return 2;
        }
        else if(left==2 || right==2) return 1;
        else if(left==1 || right==1) return 0;
        // System.out.println("error maybe");
        return -1;
    }
}