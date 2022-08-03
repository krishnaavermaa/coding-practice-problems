/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if(original==target) return cloned;
            if(original.left==null && original.right==null) return null;
            TreeNode left=null,right=null;
            if(original.left!=null) left=getTargetCopy(original.left,cloned.left,target);
            if(left!=null) return left;
            if(original.right!=null) right=getTargetCopy(original.right,cloned.right,target);
            if(right!=null) return right;
            return null;
    }
}