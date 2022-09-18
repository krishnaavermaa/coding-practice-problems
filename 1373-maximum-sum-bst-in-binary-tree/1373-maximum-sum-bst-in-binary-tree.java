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
    Map<TreeNode,Boolean> isBST;
    public int maxSumBST(TreeNode root) {
        res=0;
        isBST=new HashMap<>();
        recurr(root);
        return res;
    }
    public int[] recurr(TreeNode root)
    {
        if(root.left==null && root.right==null)
        {
            if(root.val>res) res=root.val;
            isBST.put(root,true);
            return new int[]{root.val,root.val,root.val};
        }
        int[] L=new int[]{0,Integer.MAX_VALUE,Integer.MIN_VALUE},
        R=new int[]{0,Integer.MAX_VALUE,Integer.MIN_VALUE};
        int sum=0,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        boolean flag=true;
        if(root.left!=null){
            L=recurr(root.left);
            if(L[1]<min) min=L[1];
            if(L[2]>max) max=L[2];
            if(root.left.val>=root.val || !isBST.get(root.left) || root.val<=L[2]) flag=false;
        }
        if(root.right!=null){
            R=recurr(root.right);
            if(R[1]<min) min=R[1];
            if(R[2]>max) max=R[2];
            if(root.right.val<=root.val || !isBST.get(root.right) || root.val>=R[1]) flag=false;
        }
        if(flag){
            sum+=root.val+L[0]+R[0];
            if(res<sum) res=sum;
        }
        isBST.put(root,flag);
        return new int[]{sum,min,max};
    }
}