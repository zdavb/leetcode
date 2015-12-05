/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        ListNode slow = newHead;
        //将slow移动到合适的地方
        while(slow.next != null){
            if(slow.next.val >= x)
                break;
            slow = slow.next;
        }
        
        ListNode prev = slow;
        ListNode fast = prev.next;
        
        while(fast != null){
            if(fast.val >= x){
                prev = fast;
                fast = fast.next;
            }else{
                ListNode needMove = fast;
                prev.next = fast.next;
                fast = fast.next;
                
                needMove.next = slow.next;
                slow.next = needMove;
                slow = needMove;
            }
            
        }
        return newHead.next;
    }
}