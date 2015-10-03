/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode prev = null;
         ListNode head = null;
         
         int prevVal = 0;
         while(l1!=null || l2!=null){
             int val = prevVal;
             if(l1!=null){
                 val+=l1.val;
                 l1 = l1.next;
             }
             if(l2!=null){
                 val+=l2.val;
                 l2 = l2.next;
             }
             prevVal = val/10;
             ListNode node = new ListNode(val%10);
             if(prev==null){
                 head = node;
             }else{
                 prev.next = node;
             }
             prev = node;
         }
         if(prevVal>0)
            prev.next = new ListNode(prevVal);
        return head;
    }
}