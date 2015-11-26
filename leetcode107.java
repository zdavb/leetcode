tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        
        if(root != null)
            list1.add(root);
        
        while(list1.size()!=0){
            List<Integer> vallist = new LinkedList<>();
            
            while(list1.size()!=0){
                TreeNode top = list1.removeFirst();
                vallist.add(top.val);
                
                if(top.left != null)
                    list2.add(top.left);
                if(top.right != null)
                    list2.add(top.right);
            }
            res.add(vallist);
            LinkedList<TreeNode> tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        Collections.reverse(res);
        return res;
    }
}
