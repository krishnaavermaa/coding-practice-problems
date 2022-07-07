/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0,lenB=0;
        ListNode p=headA,q=headB;
        while(p!=null){
            lenA++;
            p=p.next;
        }
        while(q!=null){
            lenB++;
            q=q.next;
        }
        if(lenA>lenB){
            while(lenA-lenB!=0){
                headA=headA.next;
                lenA--;
            }
        }
        if(lenB>lenA){
            while(lenB-lenA!=0){
                headB=headB.next;
                lenB--;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}