/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//思想是维护两个指针，分别指向父节点，以及子节点，然后在遍历父节点的过程中，完成子节点的连接
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode parent = root;
        
        while(parent != null && parent.left != null){
            TreeLinkNode nextparent = parent.left;
            TreeLinkNode prev = parent.left;
            boolean left = false;
            
            while(parent != null){
                TreeLinkNode cur = null;
                if(left)
                    cur = parent.left;
                else{
                    cur = parent.right;
                    parent = parent.next;
                }
                left = !left;
                prev.next = cur;
                prev = cur;
            }
            parent = nextparent;
        }
    }
}