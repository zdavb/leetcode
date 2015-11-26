/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head,null);
    }
    private TreeNode buildBST(ListNode left,ListNode right){
        if(left == right)
            return null;
        
        ListNode newHead = new ListNode(-1);
        newHead.next = left;
        
        ListNode slow = newHead,fast = newHead;
        
        while(fast != right){
            slow = slow.next;
            if(fast!=right) fast = fast.next;
            if(fast!=right) fast = fast.next;
        }
        
        TreeNode leftNode = buildBST(left,slow);
        TreeNode rightNode = buildBST(slow.next,right);

        TreeNode root = new TreeNode(slow.val);
        root.left = leftNode;
        root.right = rightNode;
        
        return root;
    }
}