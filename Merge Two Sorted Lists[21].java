//older version
//ugly
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode prev = head;
        
        while(l1!=null && l2 != null){
            if(l1.val < l2.val){
                if(prev==null){
                    head = l1;
                }else{
                    prev.next = l1;
                }
                prev = l1;
                l1 = l1.next;
            }else{
                if(prev == null){
                    head = l2;
                }else
                    prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            if(prev==null){
                head = l1;
            }else
                prev.next = l1;
        }
        if(l2 != null){
            if(prev == null)
                head = l2;
            else
                prev.next = l2;
        }
        return head;
    }
}
//better one
//more elegant
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                prev.next = l1;prev = l1;l1 = l1.next;
            }else{
                prev.next = l2;prev = l2;l2 = l2.next;
            }
        }
        if(l1!=null){
            prev.next = l1;
        }else if(l2 != null)
            prev.next = l2;
            
        return head.next;
    }
}