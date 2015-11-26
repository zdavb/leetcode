tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isValid(root.left,root.right);
    }
    private boolean isValid(TreeNode left,TreeNode right){
        if(left == null || right == null){
            if(left == null && right == null)
                return true;
            return false;
        }
        if(left.val != right.val)
            return false;
        
        if(isValid(left.left,right.right)){
            if(isValid(left.right,right.left))
                return true;
        }
        return false;
    }
}
