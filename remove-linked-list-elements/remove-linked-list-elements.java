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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode prev=null,ptr=head;
        while(ptr!=null)
        {
            if(ptr.val==val){
                if(prev!=null){
                    prev.next=ptr.next;
                    ptr=ptr.next;
                }
                else if(prev==null){
                    head=head.next;
                    ptr=head;
                }
            }
            else{
                prev=ptr;
                ptr=ptr.next;
            }
        }
        return head;
    }
}