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
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode p=head,q=head;
        while(q!=null && q.next!=null){
            p=p.next;
            q=q.next.next;
            if(p==q) break;
        }
        if(p==q && q!=null && q.next!=null){
            while(head!=p && p.next!=null){
                p=p.next;
                head=head.next;
            }
            return head;
        }
        return null;
    }
}