/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return false;
        boolean flag=false;
        ListNode p=head,q=head.next.next;
        while(!flag)
        {
            if(p==q && p!=null) flag=true;
            else{
                p=p.next;
                if(p==null || q==null || q.next==null) break;
                q=q.next.next;
            }
        }
        return flag;
    }
}