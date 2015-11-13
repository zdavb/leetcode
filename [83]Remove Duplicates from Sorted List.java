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
        if(head == null)
            return head;
            
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        
        while(fastNode != null){
            while(fastNode != null && fastNode.val == slowNode.val){
                fastNode = fastNode.next;
            }
            slowNode.next = fastNode;
            slowNode = fastNode;
            
        }
        return head;
    }
}