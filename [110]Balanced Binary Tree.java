/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//思想是利用递归
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(checkBalance(0,root) != -1)
            return true;
        return false;
    }
    private int checkBalance(int level,TreeNode root){
        if(root == null){
            return level;
        }
        int leftLevel = checkBalance(level+1,root.left);
        if(leftLevel == -1)
            return -1;
        int rightLevel = checkBalance(level+1,root.right);
        if(rightLevel == -1)
            return -1;
        
        int max = Math.max(rightLevel,leftLevel);
        int min = Math.min(rightLevel,leftLevel);
        
        if(max - min > 1)
            return -1;
        return max;
    }
}