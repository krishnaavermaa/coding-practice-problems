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
    List<TreeNode> res;
    Map <String,Integer> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res=new LinkedList<>();
        map=new HashMap<>();
        recurr(root,0);
        return res;
    }
    public String recurr(TreeNode root, int lev)
    {
        String left="",right="";
        if(root.left!=null) left=recurr(root.left,lev+1)+"L";
        if(root.right!=null) right=recurr(root.right,lev+1)+"R";
        String str=left+right+String.valueOf(root.val);
        if(map.containsKey(str))
        {
            if(map.get(str)==0){
                res.add(root);
                map.put(str,1);
            }
        }
        else map.put(str,0);
        return str;
    }
}