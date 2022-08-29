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
    Map<Integer,List<TreeNode>> memo=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!memo.containsKey(n))
        {
            List<TreeNode> res=new LinkedList<>();
            if(n==1)
            {
                TreeNode tmp=new TreeNode(0);
                res.add(tmp);
            }
            else if(n%2==1)
            {
                for(int i=1;i<=n-2;i+=2)
                {
                    List<TreeNode> leftSubtree=allPossibleFBT(i);
                    List<TreeNode> rightSubtree=allPossibleFBT(n-i-1);
                    for(TreeNode left:leftSubtree)
                        for(TreeNode right:rightSubtree)
                        {
                            TreeNode root=new TreeNode(0);
                            root.left=left;
                            root.right=right;
                            res.add(root);
                        }
                }
            }
            memo.put(n,res);
        }
        return memo.get(n);
    }
}