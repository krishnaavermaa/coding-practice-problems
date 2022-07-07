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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head,q=head;
        while(n-->0){
            q=q.next;
        }
        if(q==null){
            head=head.next;
            return head;
        }
        while(q.next!=null){
            q=q.next;
            p=p.next;
        }
        p.next=p.next!=null?p.next.next:null;
        return  head;
    }
}