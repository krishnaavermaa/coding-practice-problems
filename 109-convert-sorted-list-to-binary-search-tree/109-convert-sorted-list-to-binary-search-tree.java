/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    Map<TreeNode,Integer> height;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        height=new HashMap<>();
        TreeNode root=new TreeNode(head.val);
        height.put(root,1);
        while(head.next!=null)
        {
            head=head.next;
            insert(root,head.val);
        }
        return root;
    }
    public void insert(TreeNode root,int ele){
        if(ele<root.val){
            if(root.left!=null) insert(root.left,ele);
            else {
                root.left=new TreeNode(ele);
                height.put(root.left,1);
            }
        }
        else {
            if(root.right!=null) insert(root.right,ele);
            else {
                root.right=new TreeNode(ele);
                height.put(root.right,1);
            }
        }
        int left=height.get(root.left)!=null?height.get(root.left):0;
        int right=height.get(root.right)!=null?height.get(root.right):0;
        int bf=left-right;
        if(Math.abs(bf)>=2) {
            balance(bf,ele,root);
            return;
        }
        height.put(root,(left>=right)?left+1:right+1);
    }
    public void balance(int bf,int ele,TreeNode root)
    {
        if(bf==-2)//RR&RL
        {
            if(ele>root.right.val) RRrotate(root);
            else RLrotate(root);
        }
        else if(bf==2)//LL&LR
        {
            if(ele<root.left.val) LLrotate(root);
            else LRrotate(root);
        }
        //updating height
        TreeNode tmp=root.left;
        int left=height.get(tmp.left)!=null?height.get(tmp.left):0;
        int right=height.get(tmp.right)!=null?height.get(tmp.right):0;
        height.put(tmp,(left>=right)?left+1:right+1);
        
        tmp=root.right;
        left=height.get(tmp.left)!=null?height.get(tmp.left):0;
        right=height.get(tmp.right)!=null?height.get(tmp.right):0;
        height.put(tmp,(left>=right)?left+1:right+1);
        
        left=height.get(root.left);
        right=height.get(root.right);
        height.put(root,(left>=right)?left+1:right+1);
    }
    public void LLrotate(TreeNode root)
    {
        TreeNode tmp=new TreeNode(root.val);
        tmp.right=root.right;
        tmp.left=root.left.right;
        root.right=tmp;
        root.val=root.left.val;
        root.left=root.left.left;
    }
    public void RRrotate(TreeNode root)
    {
        TreeNode tmp=new TreeNode(root.val);
        tmp.left=root.left;
        tmp.right=root.right.left;
        root.left=tmp;
        root.val=root.right.val;
        root.right=root.right.right;
    }
    public void LRrotate(TreeNode root)
    {
        TreeNode tmp=new TreeNode(root.val);
        tmp.right=root.right;
        tmp.left=root.left.right.right;
        root.right=tmp;
        root.val=root.left.right.val;
        root.left.right=root.left.right.left;
    }
    public void RLrotate(TreeNode root)
    {
        TreeNode tmp=new TreeNode(root.val);
        tmp.left=root.left;
        tmp.right=root.right.left.left;
        root.left=tmp;
        root.val=root.right.left.val;
        root.right.left=root.right.left.right;
    }
}
