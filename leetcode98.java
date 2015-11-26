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
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean dfs(TreeNode root,long min,long max){
        if(root==null)
            return true;
        
        if(root.val > min && root.val < max){
            boolean left_status = dfs(root.left,min,root.val);
            if(!left_status)
                return false;
            boolean right_status = dfs(root.right,root.val,max);
            if(!right_status)
                return false;
            return true;
        }
        return false;
    }
}
