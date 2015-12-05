/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//简单的递归的思想
public class Solution {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}