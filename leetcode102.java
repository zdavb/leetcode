tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode>[] lists = new LinkedList[2];
        lists[0] = new LinkedList<>();
        lists[1] = new LinkedList<>();
        
        int index = 0;
        lists[index].add(root);
        
        List<List<Integer>> res = new LinkedList<>();
        
        if(root == null)
            return res;
        
        while(lists[index].size() != 0){
            List<TreeNode> otherlist = lists[(index+1) % 2];
            List<Integer> tmplist = new LinkedList<>();
            
            while(lists[index].size() != 0){
                TreeNode top = lists[index].remove(0);                
                tmplist.add(top.val);
                if(top.left != null)
                    otherlist.add(top.left);
                if(top.right != null)
                    otherlist.add(top.right);
            }
            index = (index+1)%2;
            res.add(tmplist);
        }
        return res;
    }
}
