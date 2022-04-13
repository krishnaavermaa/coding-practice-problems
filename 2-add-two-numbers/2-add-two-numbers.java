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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head=addTwo(l1,l2,0);
        
        if(head.val==-1) head=new ListNode(0);
        return head;
    }
    ListNode addTwo(ListNode l1, ListNode l2,int c)
    {
        if(l1.val==-1 && l2.val==-1 && c==0) return new ListNode(-1);
        ListNode ln;
        int n=0,i=0,j=0;
        if(l1.val!=-1) i=l1.val;
        else i=0;
            
        if(l2.val!=-1) j=l2.val;
        else j=0;

        n=i+j+c%10;
        c=c/10;

        ln=new ListNode(n%10);
        c=c+n/10;
        //System.out.print(ln.val);
        ListNode lnA=new ListNode(-1),lnB=lnA;
        if(l1.next!=null) lnA=l1.next;
        if(l2.next!=null) lnB=l2.next;
        ln.next=addTwo(lnA,lnB,c);
        if(ln.next.val==-1) ln.next=null;
        return ln;
    }
    
}