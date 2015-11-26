tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        List<TreeNode> list1 = new LinkedList<>();
        List<TreeNode> list2 = new LinkedList<>();
        
        int depth = 0;
        
        if(root != null)
            list1.add(root);
        
        while(list1.size()!=0){
            while(list1.size() != 0){
                TreeNode top = list1.remove(0);
                if(top.left != null)
                    list2.add(top.left);
                if(top.right != null)
                    list2.add(top.right);
            }
            depth++;
            List<TreeNode> tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        return depth;
    }
}
