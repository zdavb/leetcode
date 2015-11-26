tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int[] preorder;
    int[] inorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        
        return build(0,preorder.length,0,inorder.length);
    }
    //left inclusive and right excusive;
    private TreeNode build(int preLeft,int preRight,int inLeft,int inRight){
        if(preLeft == preRight || inLeft == inRight)
            return null;
            
        int rootVal = preorder[preLeft];
        int inIndex = findIndexOfInOrder(rootVal,inLeft,inRight);//在中序遍历中找到那个数据
        
        int length = inIndex;
        TreeNode left = build(preLeft+1,inIndex-inLeft+preLeft+1,inLeft,inIndex);
        TreeNode right = build(preRight-(inRight-inIndex-1),preRight,inIndex+1,inRight);
        
        TreeNode root = new TreeNode(rootVal);
        root.left = left;
        root.right = right;
        
        return root;
    }
    private int findIndexOfInOrder(int value,int left,int right){
        for(int i = left;i<right;i++){
            if(inorder[i] == value)
                return i;
        }
        return right;
    }
}
