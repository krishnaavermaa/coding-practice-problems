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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return treeMaker(head,null);
    }
    public TreeNode treeMaker(ListNode start, ListNode end)
    {
        if(start==end) return null;
        ListNode p=start,q=start;
        
        while(q!=end && q.next!=end)
        {
            p=p.next;
            q=q.next.next;
        }
        TreeNode root=new TreeNode(p.val);
        root.left=treeMaker(start,p);
        root.right=treeMaker(p.next,end);
        return root;
    }
}