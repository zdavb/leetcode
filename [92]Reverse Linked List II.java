/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode beginNode,endNode;
        ListNode prevNode = newHead,curNode=newHead,nextNode=head;
        
        int index = 0;
        while(nextNode!= null && index < m){
            prevNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
            index++;
            
        }
        while(nextNode != null && index >=m && index < n){
            ListNode tmpNode = nextNode.next;
            nextNode.next = curNode;
            curNode = nextNode;
            nextNode = tmpNode;
            index++;
        }
        prevNode.next.next = nextNode;
        prevNode.next = curNode;
        return newHead.next;
    }
}