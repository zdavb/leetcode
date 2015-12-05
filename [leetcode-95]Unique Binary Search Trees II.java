/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//递归的方法
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<Integer> list = new LinkedList<>();
        for(int i = 1;i<=n;i++)
            list.add(i);
        return construct(list);
    }
    private List<TreeNode> construct(List<Integer> list){
        int size = list.size();
        List<TreeNode> res = new LinkedList<>();
        if(size == 0){
            return res;
        }
        if(size == 1){
            TreeNode root = new TreeNode(list.get(0));
            res.add(root);
            return res;
        }
        
        for(int i = 0;i<size;i++){
            int value = list.get(i);
            
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            for(int j = 0;j<size;j++){
                if(j < i)
                    left.add(list.get(j));
                else if(j > i)
                    right.add(list.get(j));
            }
            
            List<TreeNode> leftRoot = construct(left);
            List<TreeNode> rightRoot = construct(right);
            
            int leftsize = leftRoot.size();
            int rightsize = rightRoot.size();
            
            if(leftsize == 0||rightsize == 0){
                if(leftsize == 0){
                    for(int k = 0;k<rightsize;k++){
                        TreeNode root = new TreeNode(value);
                        root.right = rightRoot.get(k);
                        res.add(root);
                    }
                }               
                else{
                    for(int k = 0;k<leftsize;k++){
                        TreeNode root = new TreeNode(value);
                        root.left = leftRoot.get(k);
                        res.add(root);
                    }
                }
                                  
            }
            for(int j = 0;j<leftsize;j++){
                for(int k = 0;k<rightsize;k++){
                     TreeNode root = new TreeNode(value);
                     root.left = leftRoot.get(j);
                     root.right = rightRoot.get(k);
                     res.add(root);
                }
            }
        }
        return res;
    }
}

//more elegant
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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<>();
        return create(1,n);
    }
    private List<TreeNode> create(int start,int end){
        List<TreeNode> res = new LinkedList<>();
        
        if(start > end){
            res.add(null);
            return res;
        }
        
        for(int i = start;i <= end;i++){
            List<TreeNode> leftRoot = create(start,i-1);
            List<TreeNode> rightRoot = create(i+1,end);
            
            int leftsize = leftRoot.size();
            int rightsize = rightRoot.size();
            
            for(int j = 0;j<leftsize;j++){
                for(int k = 0;k<rightsize;k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot.get(j);
                    root.right = rightRoot.get(k);
                    
                    res.add(root);
                }
            }
        }
        return res;
    }
}