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
    Set<TreeNode> safe;
    int limit;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit=limit;
        safe=new HashSet<>();
        Set<TreeNode> set=new HashSet<>();
        if(!recurr(root,0,set)) return null;
        return root;
    }
    public boolean recurr(TreeNode root,int sum,Set<TreeNode> set)
    {
        boolean flag=true;
        sum+=root.val;
        set.add(root);
        if(root.left==null && root.right==null)
        {
            if(sum>=limit) safe.addAll(set);
        }
        else{
            boolean left=true,right=true;
            if(root.left!=null) left=recurr(root.left,sum,set);
            if(root.right!=null) right=recurr(root.right,sum,set);
            if(!left) root.left=null;
            if(!right) root.right=null;
        }
        if(!safe.contains(root)) flag= false;
        //set.remove(root);
        return flag;
    }
    
}