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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //使用广搜的方法
        Queue<TreeNode> queueOfP = new LinkedList<>();
        Queue<TreeNode> queueOfQ = new LinkedList<>();
        
        queueOfP.offer(p);
        queueOfQ.offer(q);
        
        while(!queueOfP.isEmpty()){
            TreeNode topP = queueOfP.poll();
            TreeNode topQ = queueOfQ.poll();
            
            if(topP == null){
                if(topQ != null)
                    return false;
            }else{
                if(topQ == null || topP.val != topQ.val)
                    return false;
                queueOfP.offer(topP.left);
                queueOfP.offer(topP.right);
                
                queueOfQ.offer(topQ.left);
                queueOfQ.offer(topQ.right);
            }
        }
        return queueOfQ.isEmpty();
    }
}
