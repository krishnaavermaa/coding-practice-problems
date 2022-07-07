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
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode p=null,q=head.next;
        head.next=p;
        while(q!=null)
        {
            head.next=p;
            p=head;
            head=q;
            q=head.next;
            
        }
        head.next=p;
        return head;
        
    }
}