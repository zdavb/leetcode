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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<>();
        List<Integer> tmplist = new LinkedList<>();
        
        if(root == null)
            return res;
        
        this.sum = sum;
        findPath(root,0,tmplist);
        return res;
    }
    private void findPath(TreeNode root,int tmp,List<Integer> tmplist){
        int val = tmp+root.val;
        
        if(root.left == null && root.right == null)//find leaf
        {
            if(val == sum){
                List<Integer> innerlist = new LinkedList<>(tmplist);
                innerlist.add(root.val);
                res.add(innerlist);
            }
            return;
        }
        
        tmplist.add(root.val);
        if(root.left != null){
            findPath(root.left,val,tmplist);
        }
        if(root.right != null){
            findPath(root.right,val,tmplist);
        }
        tmplist.remove(tmplist.size()-1);
    }
}