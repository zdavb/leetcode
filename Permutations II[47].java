//提示TLE,但是自己调试的时候并没有感觉超时或怎样
public class Solution {
    HashSet<String> sets;
    
    private void dfs(List<List<Integer>> res,List<Integer> tmplist,List<Integer> remainlist){
        int size = tmplist.size();
        if(remainlist.size()==0){
            StringBuilder builder = new StringBuilder();
            for(int i = 0;i<size;i++){
                int val = tmplist.get(i);
                builder.append(val);
                builder.append('&'); 
            }
            String s = builder.toString();
            if(!sets.contains(s)){
                res.add(new ArrayList<>(tmplist));
                sets.add(s);
            }
            return;
        }
        for(int i = 0;i<remainlist.size();i++){
            int val = remainlist.get(i);
            remainlist.remove((int)i);
            tmplist.add(val);
            dfs(res,tmplist,remainlist);
            remainlist.add(i,val);
            tmplist.remove(tmplist.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        sets = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmplist = new ArrayList<>();
        List<Integer> remainlist = new LinkedList<>();
        
        for(int i = 0;i<nums.length;i++){
            remainlist.add(nums[i]);
        }
        dfs(res,tmplist,remainlist);
        return res;
    }
}

//对数组排序，对于每一层而言，只选择一个不同的元素
public class Solution {
    private void dfs(int[] nums,List<List<Integer>> res,List<Integer> tmplist,boolean[] visited){
        if(tmplist.size() == nums.length){
            res.add(new ArrayList<>(tmplist));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                tmplist.add(nums[i]);
                dfs(nums,res,tmplist,visited);
                visited[i] = false;
                tmplist.remove(tmplist.size()-1);
                
                //去重
                while(i<nums.length-1 && nums[i+1] == nums[i]) i++;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//按照从小到大排序
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmplist = new ArrayList<>();
        
        dfs(nums,res,tmplist,visited);
        return res;
    }
}