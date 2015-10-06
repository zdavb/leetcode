//use some extra data structure make the program more elegant
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode prevNode = newHead;
        newHead.next = head;
        
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            ListNode nextnext = cur.next.next;
            prevNode.next = cur.next;
            cur.next.next = cur;
            cur.next = nextnext;
            prevNode = cur;
            cur = prevNode.next;
        }
        return newHead.next;
    }
}