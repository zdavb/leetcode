//采用回溯法
public class Solution {
    private void solve(int[] candidates,int target,List<List<Integer>> res,int sum,List<Integer> list){
        if(sum == target){
            List<Integer> tmplist = new ArrayList<>();
            for(int i = 0;i<list.size();i++){
                tmplist.add(candidates[list.get(i)]);
            }
            res.add(tmplist);
            return;
        }
        int index = 0;
        if(list.size()>0)
            index = list.get(list.size()-1);
        for(int i = index;i<candidates.length;i++){
            if(sum+candidates[i]<=target){
                list.add(i);
                solve(candidates,target,res,sum+candidates[i],list);
                list.remove(list.size()-1);
            }else
                break;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> record = new ArrayList<>();//存储candidate中的索引
        Arrays.sort(candidates);
        
        solve(candidates,target,res,0,record);
        return res;
    }
}