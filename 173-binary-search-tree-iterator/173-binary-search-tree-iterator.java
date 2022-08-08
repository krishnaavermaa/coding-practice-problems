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
class BSTIterator {

    Queue<Integer> q;
    public BSTIterator(TreeNode root) {
        q=new LinkedList<>();
        while(root!=null)
        {
            if(root.left==null)
            {
                q.add(root.val);
                root=root.right;
            }
            else
            {
                TreeNode inpred=root.left;
                while(inpred.right!=null && inpred.right!=root)
                    inpred=inpred.right;
                if(inpred.right==null) {
                    inpred.right=root;
                    root=root.left;
                }
                if(inpred.right==root) {
                    q.add(root.val);
                    root=root.right;
                    inpred.right=null;
                }
                
            }
        }
    }
    
    public int next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return (q.peek()!=null);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */