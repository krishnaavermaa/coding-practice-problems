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
        System.out.print("*");
        if(p==q && q!=null && q.next!=null){
            System.out.print("_-");
            while(head!=p && p.next!=null){
                System.out.print("\n"+p.val+" "+head.val+"\n");
                p=p.next;
                head=head.next;
            }
            System.out.print("%");

            return head;
        }
        return null;
    }
}

// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         ListNode slow = head, fast = head;
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//             if (slow == fast) break;
//         }
//         if (fast == null || fast.next == null) return null;
//         while (head != slow) {
//             System.out.print("\n"+slow.val+" "+head.val+"\n");
//             head = head.next;
//             slow = slow.next;
//         }
//         return head;
//     }
// }