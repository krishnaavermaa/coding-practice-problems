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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small,large;
        if(p.val<q.val) {
            small=p.val;
            large=q.val;
        }
        else {
            small=q.val;
            large=p.val;
        }
        return find(root,small,large);
    }
    public TreeNode find(TreeNode node, int sm, int lg)
    {
        int val=node.val;
        if(val==sm || val==lg || (sm<val && lg>val)) return node;
        if(sm<val) return find(node.left,sm,lg);
        return find(node.right,sm,lg);
    }
}