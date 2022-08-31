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
    Map<Integer,List<TreeNode>> map=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n)
    {
        if(!map.containsKey(n))
        {
            List<TreeNode> tmp=new LinkedList<>();
            if(n==1)
            {
                TreeNode node=new TreeNode(0);
                tmp.add(node);
            }
            else if(n%2==1)
            {
                for(int i=1;i<n;i+=2)
                {
                    List<TreeNode> left= allPossibleFBT(i);
                    List<TreeNode> right= allPossibleFBT(n-i-1);
                    for(TreeNode l:left)
                    {
                        for(TreeNode r:right)
                        {
                            TreeNode node=new TreeNode(0);
                            node.left=l;
                            node.right=r;
                            tmp.add(node);
                        }
                    }
                }
            }
            map.put(n,tmp);
        }
        return map.get(n);
    }
}