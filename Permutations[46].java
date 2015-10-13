//本题要求一个数组的全排列，貌似测试用例里没有重复的数，因此没有查重也可以AC

public class Solution {
    private void dfs(List<List<Integer>> res,List<Integer> tmplist,List<Integer> remain){
        if(remain.size()==0){
            res.add(new ArrayList<>(tmplist));
            return;
        }
        for(int i = 0;i<remain.size();i++){
            int val = remain.get(i);
            tmplist.add(val);
            remain.remove((int)i);
            dfs(res,tmplist,remain);
            remain.add(i,val);
            tmplist.remove(tmplist.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmplist = new ArrayList<>();
        List<Integer> remain = new LinkedList<>();
        for(int i = 0;i<nums.length;i++){
            remain.add(nums[i]);
        }
        
        dfs(res,tmplist,remain);
        return res;
    }
}