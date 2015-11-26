tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        
        list1.add(root);
        boolean reverse = false;
        
        while(list1.size() != 0){
            List<Integer> list = new LinkedList<>();
            while(list1.size() != 0){
                TreeNode top = list1.removeFirst();
                list.add(top.val);
                if(top.left != null)
                    list2.add(top.left);
                if(top.right != null)
                    list2.add(top.right);
            }
            if(reverse)
                list = reverse(list);
            res.add(list);
            
            reverse = !reverse;
            LinkedList<TreeNode> tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        return res;
    }
    private List reverse(List<Integer> list){
        LinkedList<Integer> res = new LinkedList<>();
        for(int value:list){
            res.addFirst(value);
        }
        return res;
    }
}

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        
        list1.add(root);
        boolean reverse = false;
        
        while(list1.size() != 0){
            List<Integer> list = new LinkedList<>();
            while(list1.size() != 0){
                TreeNode top = list1.removeFirst();
                list.add(top.val);
                if(top.left != null)
                    list2.add(top.left);
                if(top.right != null)
                    list2.add(top.right);
            }
            if(reverse)
                Collections.reverse(list);
            res.add(list);
            
            reverse = !reverse;
            LinkedList<TreeNode> tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        return res;
    }
}
