/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //先序遍历
public class Solution {
    List<TreeNode> list;
    public void flatten(TreeNode root) {
        list = new LinkedList<>();
        if(root == null)
            return;
            
        convertTreeToList(root);
        TreeNode prev = root;
        prev.left = null;
        prev.right = null;
        
        int size = list.size();
        
        for(int i = 1;i<size;i++){
            TreeNode tmp = list.get(i);
            prev.right = tmp;
            tmp.left = null;
            tmp.right = null;
            
            prev = tmp;
        }
    }
    private void convertTreeToList(TreeNode root){
        if(root == null)
            return;
        list.add(root);
        convertTreeToList(root.left);
        convertTreeToList(root.right);
    }
}