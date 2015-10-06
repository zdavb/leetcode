/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        ListNode prevNode = newHead;
        prevNode.next = head;
        Stack<ListNode> stack = new Stack<>();
        
        ListNode cur = head;
        while(true){
            //init stack
            int num = 0;
            while(num<k && cur!=null){
                stack.push(cur);
                num++;
                cur = cur.next;
            }
            if(num<k)
                break;
            
            ListNode tmpPrev = stack.pop();
            prevNode.next = tmpPrev;
            ListNode nextnext = tmpPrev.next;
            
            while(!stack.isEmpty()){
                ListNode top = stack.pop();
                tmpPrev.next = top;
                tmpPrev = top;
            }
            tmpPrev.next = nextnext;
            prevNode = tmpPrev;
        }
        return newHead.next;
    }
}