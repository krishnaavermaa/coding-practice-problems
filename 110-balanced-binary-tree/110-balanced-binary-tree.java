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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        HashMap<TreeNode,Integer> height=new HashMap<>();
        return checkBalanced(root,height);
    }
    public boolean checkBalanced(TreeNode root,HashMap<TreeNode,Integer> height)
    {
        int lh,rh,bf;
        if(root.left==null && root.right==null) {
            height.put(root,1);
            return true;
        }
        if(root.left!=null){
           if(checkBalanced(root.left,height)==false) return false; 
        } 
        if(root.right!=null){
            if(checkBalanced(root.right,height)==false) return false;
        }
        lh=root.left!=null?height.get(root.left):0;
        rh=root.right!=null?height.get(root.right):0;
        bf=lh-rh;
        if(bf>1 || bf<-1) return false;
        height.put(root,lh>=rh?lh+1:rh+1);
        return true;
    }
}