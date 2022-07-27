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
    DecimalFormat df;
    public List<Double> averageOfLevels(TreeNode root) {
        df=new DecimalFormat();
        df.setMaximumFractionDigits(5);
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        List<Double> list=new LinkedList<>();
        q1.add(root);
        func(q1,q2,list);
        return list;
    }
    public void func(Queue<TreeNode> q1, Queue<TreeNode> q2, List<Double> list)
    {
        TreeNode node;
        Double sum=0.0;
        int c=0;
        while(!q1.isEmpty())
        {
            node=q1.poll();
            if(node.left!=null) q2.add(node.left);
            if(node.right!=null) q2.add(node.right);
            sum+=node.val;
            c++;
        }
        list.add(Double.parseDouble(String.format("%.5f",sum/(double)c)));
        if(q2.peek()!=null) func(q2,q1,list);
    }
}