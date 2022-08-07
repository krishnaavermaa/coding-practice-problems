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
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        TreeNode inpred;
        TreeNode first=null,second=null;
        while(root!=null)
        {
            if(root.left!=null)
            {
                inpred=root.left;
                while(inpred.right!=null && inpred.right!=root)
                {
                    inpred=inpred.right;
                }
                if(inpred.right==null) {
                    inpred.right=root;
                    root=root.left;
                }
                else {
                    inpred.right=null;
                    //do something with root
                    if(prev!=null && prev.val>root.val) {
                        if(first==null) first=prev;
                        if(first!=null) second=root;
                    }
                    prev=root;
                    root=root.right;
                }
            }
            else if(root.left==null){
                //do something with root
                if(prev!=null && prev.val>root.val) {
                        if(first==null) first=prev;
                        if(first!=null) second=root;
                }
                prev=root;
                root=root.right;
            }
        }
        int tmp=first.val;
        first.val=second.val;
        second.val=tmp;
    }
    
}