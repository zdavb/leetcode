public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        
        //sort nums
        Arrays.sort(nums);
        if(nums.length <= 0)
            return res;
        res.add(new LinkedList<>());
        List<Integer> toplist = new LinkedList<>();
        toplist.add(nums[0]);
        res.add(toplist);
        
        for(int i = 1;i<nums.length;i++){
            int size = res.size();
            for(int j = 0;j<size;j++){
                //插入当前
                List<Integer> tmplist = new LinkedList<>(res.get(j));
                tmplist.add(nums[i]);
                res.add(tmplist);
            }
        }
        return res;
    }
}