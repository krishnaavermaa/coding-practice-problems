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
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
    public List<TreeNode> generate(int s,int e)
    {
        List<TreeNode> list=new LinkedList<>();
        if(s>e) list.add(null);
        for(int k=s;k<=e;k++)
        {
            List<TreeNode> left=generate(s,k-1);
            List<TreeNode> right=generate(k+1,e);
            for(int i=0;i<left.size();i++)
            {
                TreeNode l=left.get(i);
                for(int j=0;j<right.size();j++)
                {
                    TreeNode root=new TreeNode(k);
                    root.left=l;
                    root.right=right.get(j);
                    list.add(root);
                }
            }
        }
        return list;
        
    }
}