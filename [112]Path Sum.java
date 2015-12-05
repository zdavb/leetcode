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
    int sum;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
            
        this.sum = sum;
        return addSumUp(0,root);
    }
    private boolean addSumUp(int tmp,TreeNode root){
        int value = tmp + root.val;
        if(root.left == null && root.right == null)//find leaf node
        {
            if(value == sum)
                return true;
            return false;
        }
        
        if(root.left != null && addSumUp(value,root.left))
            return true;
        if(root.right != null && addSumUp(value,root.right))
            return true;
        
        return false;
        
    }
}