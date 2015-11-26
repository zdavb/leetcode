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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {  
        this.nums = nums;
        return buildBST(0,nums.length);
    }
    //left inclusive and right exclusive
    private TreeNode buildBST(int left,int right){
        if(left == right)
            return null;
        int mid = (left+right)/2;
        
        TreeNode leftNode = buildBST(left,mid);
        TreeNode rightNode = buildBST(mid+1,right);
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = leftNode;
        root.right = rightNode;
        
        return root;
    }
}