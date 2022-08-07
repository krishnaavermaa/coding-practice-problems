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
    public List<List<Integer>> levelOrder(TreeNode root) {
        res=new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        q1.add(root);
        res.add(Collections.singletonList(root.val));
        levelOrder(q1,q2);
        return res;
    }
    public void levelOrder(Queue<TreeNode> q1,Queue<TreeNode> q2)
    {
        TreeNode curr;
        while(q1.peek()!=null)
        {
            curr=q1.poll();
            if(curr.left!=null) q2.add(curr.left);
            if(curr.right!=null) q2.add(curr.right);
        }
        if(q2.peek()!=null)
        {
            List<Integer> list=new LinkedList<>();
            q2.forEach(ele->list.add(ele.val));
            res.add(list);
            levelOrder(q2,q1);
        }
    }
}