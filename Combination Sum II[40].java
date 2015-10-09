//回溯法
//由于候选项中有重复项，所以结果集中会存在重复部分。
//这里，采用构造一个string，然后将其加入到hashset中。每次添加之前要检查hash集合。
public class Solution {
    Set<String> sets;
    private void solve(int[] candidates,int target,List<List<Integer>> res,List<Integer> list,int sum,int index){
        if(sum == target){
            StringBuilder s = new StringBuilder();
            for(Integer i:list){
                s.append(i);
                s.append('&');
            }
            s.deleteCharAt(s.length()-1);
            String ss = s.toString();
            if(!sets.contains(ss))
                res.add(new ArrayList<>(list));
                
            sets.add(ss);
            return;
        }
        for(int i = index+1;i<candidates.length;i++){
            if(sum+candidates[i] <= target){
                list.add(candidates[i]);
                solve(candidates,target,res,list,sum+candidates[i],i);
                list.remove(list.size()-1);
            }else
                break;
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        sets = new HashSet<>();
        
        solve(candidates,target,res,list,0,-1);
        return res;
    }
}