/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//这道题是使用递归的方法，求最大路径实际上是求左侧的最大路径（与0相比）和右侧的最大路径（与0相比）
//然后再加根节点，构成总和，然后与sum值比较大小
public class Solution {
    int sum = 0;
    
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        sum = root.val;//初始化为根节点值
        dfs(root);
        return sum;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftPathMax = dfs(root.left);
        int rightPathMax = dfs(root.right);
        if(leftPathMax < 0)
            leftPathMax = 0;
        if(rightPathMax < 0)
            rightPathMax = 0;
        
        int value = root.val + leftPathMax + rightPathMax;
        if(value > sum)
            sum = value;
            
        return Math.max(leftPathMax,rightPathMax) + root.val;
    }
}