/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int getSize(ListNode head){
        int num = 0;
        while(head != null){
            num++;
            head = head.next;
        }
        return num;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        int size = getSize(head);
        k = k%size;
        if(k == 0)
            return head;
        ListNode slow = head,fast = head;
        int curIndex = 0;
        while(curIndex < k){
            fast = fast.next;
            curIndex++;
        } 
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}