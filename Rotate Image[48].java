public class Solution {
    public void rotate(int[][] matrix) {
        int left = 0,right = matrix.length-1;
        
        while(left<right){
            int val;
            for(int i = 0;i<right-left;i++){
                val = matrix[left][left+i];
                matrix[left][left+i] = matrix[right-i][left];
                matrix[right-i][left] = matrix[right][right-i];
                matrix[right][right-i] = matrix[left+i][right];
                matrix[left+i][right] = val;
            }
            left++;right--;
        }
        
    }
}