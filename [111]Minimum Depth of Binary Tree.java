/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//首先明确什么是叶节点，叶节点就是指左右子树都是空的
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return findMinDepth(1,root);
    }
    private int findMinDepth(int level,TreeNode root){
        if(root.left == null && root.right == null)
            return level;
            
        int leftLevel = Integer.MAX_VALUE;
        int rightLevel = Integer.MAX_VALUE;
        
        if(root.left != null)
            leftLevel = findMinDepth(level+1,root.left);
        if(root.right != null)
            rightLevel = findMinDepth(level+1,root.right);
            
        return Math.min(leftLevel,rightLevel);
        
    }
}