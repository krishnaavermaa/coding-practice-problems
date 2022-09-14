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
    Set<Integer> set;
    long max;
    TreeNode head;
    public int maxProduct(TreeNode root) {
        max=0L;
        head=root;
        set=new HashSet<>();
        recurr(root);
        long t=max;
        set.remove(max);
        max=0L;
        Iterator<Integer> it=set.iterator();
        while(it.hasNext())
        {
            int v=it.next();
            if(v*(t-v)>max) max=v*(t-v);
        }
        return (int)(max%1000000007);
    }
    public int recurr(TreeNode root)
    {
        if(root==null) return 0;
        int sum=recurr(root.left)+recurr(root.right)+root.val;
        if(root==head) max=sum;
        set.add(sum);
        return sum;
    }
}