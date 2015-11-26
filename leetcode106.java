tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int[] inorder;
    int[] postorder;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        
        return build(0,inorder.length,0,postorder.length);    
    }
    private TreeNode build(int inLeft,int inRight,int postLeft,int postRight){
        if(inLeft == inRight || postLeft == postRight)
            return null;
        
        int rootVal = postorder[postRight-1];
        int inIndex = findIndexOfInOrder(rootVal,inLeft,inRight);
        
        TreeNode left = build(inLeft,inIndex,postLeft,inIndex-inLeft+postLeft);
        TreeNode right = build(inIndex+1,inRight,inIndex-inLeft+postLeft,postRight-1);
        
        TreeNode root = new TreeNode(rootVal);
        root.left = left;
        root.right = right;
        
        return root;
    }
    private int findIndexOfInOrder(int val,int left,int right){
        for(int i = left;i<right;i++){
            if(inorder[i] == val)
                return i;
        }
        return right;
    }
}
