/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        ListNode slowNode = newHead;
        ListNode fastNode = head;
        
        while(fastNode != null){
            int count = 0;
            while(fastNode.next != null && fastNode.next.val == fastNode.val){
                fastNode = fastNode.next;
                count++;
            }
            if(count == 0){
                slowNode.next = fastNode;
                slowNode = fastNode;
            }
            
           fastNode = fastNode.next;
           
        }
        slowNode.next = null;
        return newHead.next;
    }
}