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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next ==null || head.next.next==null) return head;
        ListNode o=head,e=head.next,ee=e,tmp=o.next;
        // ListNode o=head,e=head.next,ee=e,tmp;
        while(true)
        {
            if(o.next!=null && o.next.next!=null){
                o.next=o.next.next;
                o=o.next;
            }
            if(e.next!=null && e.next.next!=null){
                e.next=e.next.next;
                e=e.next;
            }
            if((o.next==null || o.next.next==null) && (e.next==null || e.next.next==null)) {
                e.next=null;
                o.next=ee;
                return head;
            }
        }
            
    }
}