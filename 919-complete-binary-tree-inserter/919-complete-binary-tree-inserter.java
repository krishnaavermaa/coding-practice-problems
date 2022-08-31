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
class CBTInserter {

    ArrayDeque<TreeNode> q;
    TreeNode head;
    public CBTInserter(TreeNode root) {
        q=new ArrayDeque<>();
        head=root;
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode tmp=q.pollFirst();
            if(tmp.left!=null) q.addLast(tmp.left);
            if(tmp.right!=null) q.addLast(tmp.right);
            if(tmp.left==null || tmp.right==null) {
                q.addFirst(tmp);
                break;
            }
        }
    }
    
    public int insert(int val) {
        TreeNode node=new TreeNode(val);
        TreeNode tmp=q.pollFirst();
        if(tmp.left==null) {
            q.addFirst(tmp);
            tmp.left=node;
        }
        else if(tmp.right==null) tmp.right=node;
        q.addLast(node);
        return tmp.val;
    }
    
    public TreeNode get_root() {
        return head;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */