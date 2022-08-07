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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res=new LinkedList<>();
        if(root==null) return res;
        LinkedList<Integer> list=new LinkedList<>();
        DFS(root,list,0,targetSum);
        return res;
    }
    public void DFS(TreeNode root,LinkedList<Integer> list,int sum,int targetSum)
    {
        sum+=root.val;
        list.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(sum==targetSum) res.add((List<Integer>)list.clone());
            list.pollLast();
            return;
        }
        if(root.left!=null) DFS(root.left,list,sum,targetSum);
        if(root.right!=null) DFS(root.right,list,sum,targetSum);
        list.pollLast();
    }
}