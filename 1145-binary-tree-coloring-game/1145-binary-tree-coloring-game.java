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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int Lnodes=0;
        int Rnodes=0;
        int Pnodes=0;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode tmp=stack.pop();
            if(tmp.val==x) 
            {
                Lnodes=countNodes(tmp.left);
                Rnodes=countNodes(tmp.right);
                break;
            }
            //Pnodes++;
            if(tmp.right!=null) stack.push(tmp.right);
            if(tmp.left!=null) stack.push(tmp.left);
        }
        Pnodes=n-(Lnodes+Rnodes+1);
        if(Pnodes>Lnodes+Rnodes+1 || Lnodes>Pnodes+Rnodes+1 || Rnodes>Pnodes+Lnodes+1) return true;
        return false;
    }
    public int countNodes(TreeNode root)
    {
        if(root==null) return 0;
        int c=0;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            c++;
            TreeNode tmp=stack.pop();
            if(tmp.right!=null) stack.push(tmp.right);
            if(tmp.left!=null) stack.push(tmp.left);
        }
        return c;
    }
}