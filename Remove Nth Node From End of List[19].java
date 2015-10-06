/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0)
            return head;
        int index = 0;
        ListNode fast = head,slow = head;
        while(index<n && fast!=null){
            fast = fast.next;
            index++;
        }
        if(fast == null)//n太大
            return head.next;
        
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}