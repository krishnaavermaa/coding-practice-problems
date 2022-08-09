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
    public int kthSmallest(TreeNode root, int k) {
        while(root!=null)
        {
            if(root.left==null)
            {
                if(--k==0) return root.val;
                root=root.right;
            }
            else{
                TreeNode inpred=root.left;
                while(inpred.right!=null && inpred.right!=root)
                    inpred=inpred.right;
                if(inpred.right==null) {
                    inpred.right=root;
                    root=root.left;
                }
                else{
                    inpred.right=null;
                    if(--k==0) return root.val;
                    root=root.right;
                }
            }
        }
        return -1;
    }
}