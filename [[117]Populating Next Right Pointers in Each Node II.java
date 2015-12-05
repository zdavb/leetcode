/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode nextparent = null;
            TreeLinkNode prev = null;
            TreeLinkNode cur = null;
            
            boolean left = true;
            while(root != null){
                if(left){
                    cur = root.left;
                }else{
                    cur = root.right;
                    root = root.next;
                }
                
                if(cur != null){
                    if(prev == null){
                        prev = cur;
                        nextparent = cur;                        
                    }else{
                        prev.next = cur;
                        prev = cur;
                    }
                }
                left = !left;//取反
            }
            root = nextparent;
        }
    }
}